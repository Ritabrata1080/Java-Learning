/*
 Developed by Ritabrata, 2024
 */


class PerformOperations {
    public void performDivision(int a, int b) {
        try {
            System.out.println(a / b);
        }
        // Since in this case we know it will throw an Arithmetic exception in try block, so
        // we are catching the exception through ArithmeticException
        catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
        }
        // This catch block will catch generic exception.
        // It is used when we don't know the possible cause for exception
        catch (Exception e) {
            // getMessage() will only give the reason of exception without any class details or stackTrace
            //System.out.println("Cannot perform division : " + e.getMessage());

            // printStackTrace() will print the entire stacktrace causing the exception and
            // also the class name and API name causing the exception
            e.printStackTrace();
        }
    }

    public void getLength(String s){
        try{
            System.out.println(s.length());
        } catch (IndexOutOfBoundsException | NullPointerException np){ // We can club multiple exception reasons
            System.out.println("Exception cause : " + np.getMessage());
        }
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        PerformOperations obj = new PerformOperations();
        obj.performDivision(100, 0);
        obj.getLength(null);
    }
}
