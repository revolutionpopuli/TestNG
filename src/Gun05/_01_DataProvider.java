package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_DataProvider {

    @Test(dataProvider = "getData")//Benim data sağlayıcım getData fonksiyonudur.
    void searchTest(String searchTest){
        System.out.println("searchTest = " + searchTest);
    }

    @DataProvider//bu metoda dataprovider görevi verildi
    public Object[] getData(){//DataProvider olarak kullanılacak metodun tipi object olmak zorunda

        //int[] dizi={1, 2, 3, 4}
        Object[] data={"Mac", "Samsung", "Huawei", "Iphone", "PC", "Xaomi"};

        return data;
    }

    /*****************************************************************/
    @Test(dataProvider = "aranacaklar")
    void searchTest2(String searchTest){
        System.out.println("searchTest = " + searchTest);
    }

    @DataProvider(name = "aranacaklar")//isimle de çağrılabiliyor
    public Object[] getData2(){
        Object[] data={"Mac", "Samsung", "Huawei", "Iphone", "PC", "Xaomi"};

        return data;
    }



}
