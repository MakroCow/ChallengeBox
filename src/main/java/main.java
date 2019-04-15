public class main {

    public static void main(String[]args){
        TestConnection tc = new TestConnection();
        try{
            tc.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
