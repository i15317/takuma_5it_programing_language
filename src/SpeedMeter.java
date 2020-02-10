import java.util.ArrayList;
import java.util.List;

public class SpeedMeter {
    //最高速度(160km/h)
    private final Double MAX_SPEED = 160.0;
    //最低速度(今回はバックは考えない）
    private final Double MIN_SPEED = 0.0;
    private Double m_currentSpeed = 0.0;
    private List<Double> m_oldSpeed = new ArrayList<Double>();

    SpeedMeter() {
    }

    public Boolean SpeedRecord(Double currentSpeed) {
        m_oldSpeed.add(m_currentSpeed);
        m_currentSpeed += currentSpeed;
        if (m_currentSpeed < MIN_SPEED) m_currentSpeed = MIN_SPEED;
        return m_currentSpeed <= MAX_SPEED;
    }

    public void DispSpeed() {
        System.out.println(m_currentSpeed.toString() + "km/h");
    }

    //警察が調べるときはこれを見ればよい（笑）
    public void DispSpeedLog() {
        for (Double speed : m_oldSpeed) {
            System.out.println("Speed Log:" + speed.toString() + " km/h");
        }
    }

}
