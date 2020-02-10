public class Main {
    //便宜的なメインの実行メソッド
    public static void main(String[] args) {
        SuperCar superCar = new SuperCar();
        NormalCar normalCar = new NormalCar();
        while(true) {
            superCar.Lifecycle();
            normalCar.Lifecycle();
        }

    }
}
