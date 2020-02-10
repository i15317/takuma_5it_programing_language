import java.util.Scanner;

public class SpeedController {
    protected SpeedMeter m_SpeedMeter;
    //加速度は2.5km/h/sがデフォルト
    private final Double ACCELERATION = 2.5;
    //減速度は4.2km/h/sがデフォルト
    private final Double DECELERATION = -4.2;
    //空気抵抗(0.3km/h/s)（惰性走行のためとりあえず設定。本来物理演算を車側が担うことはない）
    private final Double AIR_RESIST = -0.3;
    //補正の上限
    private Double MAX_CORRECTION = 1.5;
    //計器からの警告
    private int m_Status = 0;

    //加速度の補正
    private Double m_AccelerationCorrection = 0.0;
    private Double m_DecelerationCorrection = 0.0;

    SpeedController() {
        //スピードメーターのインスタンスを作成
        m_SpeedMeter = new SpeedMeter();
    }

    void Lifecycle() {
        //ユーザーコントロールシーケンス
        var key = UserAction();
        if (key.contains("a")) {
            if (m_Status == 0)
                Accelerator();
            else
                Braking();
        } else if (key.contains("b")) {
            Braking();
        } else if (key.contains("c")) {
            m_SpeedMeter.DispSpeedLog();
        } else if (key.contains("e")) {
            //強制終了
            System.out.println("緊急停止します");
            System.exit(0);
        } else {
            Inertia();
        }
        //メーター表示
        m_SpeedMeter.DispSpeed();
    }

    private String UserAction() {
        System.out.println("運転操作です。Aで加速、Bで減速です。それ以外は無効な入力となります。");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    private void Accelerator() {
        m_Status = m_SpeedMeter.SpeedRecord(ACCELERATION + m_AccelerationCorrection) ? 0 : 1;
    }

    private void Braking() {
        m_Status = m_SpeedMeter.SpeedRecord(DECELERATION - m_DecelerationCorrection) ? 0 : 1;
    }

    private void Inertia() {
        m_Status = m_SpeedMeter.SpeedRecord(AIR_RESIST) ? 0 : 1;
    }

    void TuningAcceleration(Double value) {
        m_AccelerationCorrection += value;
        m_AccelerationCorrection = m_AccelerationCorrection <= MAX_CORRECTION ? 0 <= m_AccelerationCorrection ? m_AccelerationCorrection :
                0 : MAX_CORRECTION;
    }

    void TuningDeccleration(Double value) {
        m_DecelerationCorrection += value;
        m_DecelerationCorrection = m_DecelerationCorrection <= MAX_CORRECTION ? 0 <= m_DecelerationCorrection ? m_DecelerationCorrection :
                0 : MAX_CORRECTION;
    }

}

