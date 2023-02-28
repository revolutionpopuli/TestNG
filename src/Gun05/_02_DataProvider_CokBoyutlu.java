package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider_CokBoyutlu {

    @Test(dataProvider = "getData")
    void loginTest(String username, String password){
        System.out.println("username="+username+", password="+password);
    }


    @DataProvider
    public Object[][] getData(){
        Object[][] logins={
                {"ali","123"},
                {"veli", "456"},
                {"ahmet", "789"},
                {"mehmet", "0102"}

        };
        return logins;
    }


}
