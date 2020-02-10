public class NormalCar extends Car {
    private String m_carName = "";

    @Override
    protected Boolean Initialize() {
        setCarTitle("SampleCar");
        this.m_SpeedController.TuningAcceleration(0.3);
        this.m_SpeedController.TuningDeccleration(0.3);
        DispCarName();
        return true;
    }

    @Override
    protected void ChildLifecycle() {
        System.out.println("普通の車の機能を実行します");
    }

    //レポートの仕様を満たすやつ
    void setCarTitle(String title) {
        m_carName = title;
    }

    void setCarTitle() {
        setCarTitle("Default");
    }
    private void DispCarName(){
        System.out.println("この車の名前は" + m_carName + "です。");
    }

}
