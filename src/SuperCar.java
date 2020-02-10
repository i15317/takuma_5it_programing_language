public class SuperCar extends Car {

    @Override
    protected Boolean initialize() {
        //スーパーカーならではの機能を実装する場合はここで初期化する
        System.out.println("スーパーカーは走れます！");
        return true;
    }

    @Override
    protected void ChildLifecycle() {
        //とりあえず何もしない
        System.out.println("スーパーカーの機能を実行します");
    }

}
