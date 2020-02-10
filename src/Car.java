abstract public class Car {
    private Boolean m_StopFlag = false;
    protected SpeedController m_SpeedController;

    /**
     * これらは本来はインターフェースを使用するものです。
     * 　今回はレポートの仕様に合わせるため”あえて”抽象クラスを使いました
     */
    //車の初期処理
    abstract protected Boolean Initialize();

    //派生クラス用ライフサイクルメソッド
    abstract protected void ChildLifecycle();

    Car() {
        //SpeedControllerの初期化
        m_SpeedController = new SpeedController();
        //派生クラスで実行される初期処理を実装する
        Initialize();
    }

    //ライフサイクルメソッド
    public void LifeCycle() {

        //基底クラスのライフサイクルメソッド
        m_SpeedController.LifeCycle();
        //派生クラスで完結するライフサイクルメソッドを実行
        ChildLifecycle();

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


}
