package Gun02;

import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Dependency extends BaseDriver {
    @Test
    void startCar(){
        System.out.println("start car");
        Assert.fail();
    }
    @Test(dependsOnMethods = {"startCar"})//bu testin çalışması, startCarın hatasız çalışmasına bağlı
    void driveCar(){
        System.out.println("drive car");
    }
    @Test(dependsOnMethods ={ "startCar", "driveCar"})
    void parkCar(){
        System.out.println("park car");
    }
    @Test(dependsOnMethods = {"parkCar"}, alwaysRun = true)//alwaysRun=true bağımlılıkları var ama hata çıkarsa da yine çalıştır.
    void stopCar(){
        System.out.println("stop car");
    }
    // aynı seviyedeki testleri için priority verilebilir.
    // bağımlı testler, direkt metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde 2 üste kadar ototmatik çağırıp çalışabilir.


}
