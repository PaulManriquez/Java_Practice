package CheckingSystem;

public class GetSystemClass {


    public static void main(String[] args){
        String opSystem = System.getProperty("os.name");

        Runtime rt = Runtime.getRuntime();
        Process process;

        try{//
            if(opSystem.startsWith("Win")){
                process = rt.exec("notepad");
            }else System.out.println("No windows system");

        }catch (Exception e){
            System.out.println("ERROR: "+ e);
        }
    }

}
