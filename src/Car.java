abstract public class Car {
    private Boolean m_StopFlag = false;
    protected SpeedMeter m_SpeedMeter;
    protected SpeedController m_SpeedController;

    /**
     * これらは本来はインターフェースを使用するものです。
     * 　今回はレポートの仕様に合わせるため”あえて”抽象クラスを使いました
     */
    //車の初期処理
    abstract Boolean initialize();

    //車を走らす命令
    abstract void run();

    //車を止める命令
    abstract void stop();

    //派生クラス用ライフサイクルメソッド
    abstract void childLifecycle();

    Car() {
        //SpeedMeterの初期化

        //SpeedControllerの初期化

        //派生クラスで実行される初期処理を実装する
        initialize();

        //ライフサイクルメソッドの呼び出し
        lifeCycle();
    }

    //　エラーコードを取得する
    // Askするな！！！！
    Boolean getErrorCode() {
        return m_StopFlag;
    }

    //何もしない
    void setErrorCode() {
        m_StopFlag = true;
    }

    //スピードメーターの表示（実質的なprintf的なやつ）
    private void dispSpeedMeter() {

    }

    //ライフサイクルメソッド
    private void lifeCycle() {
        //車を走らす
        run();
        //車が走り続ける間
        while (!m_StopFlag) {
            dispSpeedMeter();

            //子クラスのライフサイクルメソッドは必ず最後に呼ばれる
            childLifecycle();
        }
        //車が止まる
        stop();
    }

}
