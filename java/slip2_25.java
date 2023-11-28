
public class slip2_25
{
public static void main(String s[])

{
ABC obj1 = ABC.getInstance();
ABC obj2 = ABC.getInstance();
obj1.showMessage();
}
}
class ABC
{
static ABC obj = new ABC();
String name = "Gaurav";
private ABC() {}

public static ABC getInstance()
{

return obj;

}
public void showMessage()
   {
      System.out.println("Hello "+name+" !!!!! ");
   }
}
