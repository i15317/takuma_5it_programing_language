public class SuperCar extends Car {

    @Override
    protected Boolean Initialize() {
        //スーパーカーならではの機能を実装する場合はここで初期化する
        this.m_SpeedController.TuningAcceleration(0.7);
        this.m_SpeedController.TuningDeccleration(0.4);
        DispCarSpec();
        return true;
    }

    @Override
    protected void ChildLifecycle() {
        System.out.println("スーパーカーの機能を実行します");
    }

    private void DispCarSpec() {
        System.out.println("スーパーカーのスペック：");
        System.out.println("この車の加速度： 3.2km/h/s");
        System.out.println("この車の減速度： 4.6km/h/s");
    }

    private void DispCarStatus() {
        System.out.println("この車は正常に機能しています");
    }
}
