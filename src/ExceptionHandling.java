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

    public int getArrayLength(int[] a){
        try{
            return a.length;
        } catch (NullPointerException np){
            System.out.println("Array is null : " + np.getMessage());
        }
        return 0;
    }

    // Making aware that this API could throw an exception. Possibly to be handled with try catch
    public void getArrayIndexThrowException(int[] a, int index) throws ArrayIndexOutOfBoundsException {
        System.out.println(a[index]);
    }

    //Handling the exception through try catch block
    public void getArrayIndexHandleException(int[] a, int index) {
        try{
            System.out.println(a[index]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        PerformOperations performOperationsObject = new PerformOperations();
        performOperationsObject.performDivision(100, 0);
        performOperationsObject.getLength(null);
        int[] arr = null;
        int res = performOperationsObject.getArrayLength(null);
        System.out.println(res);
        int[] testArray;
        testArray = new int[]{0, 1, 2};
        performOperationsObject.getArrayIndexHandleException(testArray, 3);
        performOperationsObject.getArrayIndexThrowException(testArray, 3);
    }
}
