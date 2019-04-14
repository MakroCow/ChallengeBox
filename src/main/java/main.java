public class main {

    public static void main(String[]args){
        System.out.println("HIIII HERE AM I");
        TestConnection tc = new TestConnection();
        try{
            tc.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
