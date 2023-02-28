package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _03_DataProvider_Iterator {


    @Test(dataProvider = "getData")
    void searchTest(String searchTest){
        System.out.println("searchTest = " + searchTest);
    }

    @DataProvider
    public Iterator <Object> getData() {

        List<Object> data = new ArrayList<>();
        data.add("Mac");
        data.add("Samsung");
        data.add("Huawei");


        return data.iterator();
    }

    @Test(dataProvider = "getData2")
    void loginTest(String username, String password){
        System.out.println("username = " + username+", password="+password);
    }

    @DataProvider
    public Iterator <Object[]> getData2() {

        List<Object[]> logins = new ArrayList<>();
        logins.add(new Object[] {"ali","asd3"});
        logins.add(new Object[] {"veli","asd4"});
        logins.add(new Object[] {"ahmet","asd5"});


        return logins.iterator();
    }

}
