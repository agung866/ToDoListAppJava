import java.util.Scanner;

public class ToDoListApp {

    public static String[]model=new String[10];
    public static Scanner scan=new Scanner(System.in);

    public static void main(String[] args) {
        viewShowToDoList();
    }

    // menampilakn todolist
    public static void showToDoList(){
        System.out.println("To Do List");
        for(var i = 0; i<model.length;i++){
            var todo = model[i];
            var no = i+1;

            if(todo !=null){
                System.out.println(no+". "+todo );
            }
        }

    }

    public static void testShowToDoList(){
        model[0]="belajar java dasar";
        model[1]="belajar java todo list";
        showToDoList();
    }

    //menambahkan todo list
    public static void addToDoList(String todo){
        var isFull = true;
        //cek model penuh atu tidak
        for(var i=0;i<model.length;i++){
            if(model[i]==null){
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        //penuh kita resize
        if(isFull){
            var temp =model;
            model=new String[model.length*2];

            for(var i = 0; i< temp.length;i++){
                model[i]=temp[i];
            }
        }

        //tambahkan ke posisi yang data arraynya null
        for(var i =0;i< model.length;i++){
            if(model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }
        public static void testAddToDoList() {
            for (var i = 0; i < 25; i++) {
                addToDoList("contoh"+i);
            }
            showToDoList();
        }

    //Menghapus todo List
    public static boolean deleteToDoList(Integer number){
        if((number-1)>= model.length) {
            return false;
        }else if(model[number-1]==null){
            return false;
        }else{
            model[number - 1]=null;

            for (var i=(number-1);i<model.length;i++){
               if(i==(model.length-1)){
                   model[i]=null;
               }else{
                   model[i]=model[i+1];
               }
            }
            return true;
        }
    }
    public static void testDeleteToDoList() {
       addToDoList("satu");
        addToDoList("dua");
        addToDoList("tiga");

        var result = deleteToDoList(20);
        System.out.println(result);

        result = deleteToDoList(4 );
        System.out.println(result);
        result = deleteToDoList(2 );
        System.out.println(result);

        showToDoList();
    }

    public static String input(String info) {
        System.out.print(info+ " : ");
        String data = scan.nextLine();
        return data;
    }
    public static void testInput() {
        var name =input("nama");
        System.out.println("Hi "+ name);
    }

    // tampilan lihat to do list
    public static void viewShowToDoList(){
        while (true){
            showToDoList();

            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("pilih");
            if(input.equals("1")){
                viewAddToDoList();
            }else if(input.equals("2")){
                viewDeleteToDoList();
            }else if(input.equals("x")) {
                break;
            }else{
                System.out.println("Pilih menu yang sesuai");
            }
            }
        }

        public static void testViewToDoList(){
        addToDoList("satu");
        addToDoList("dua");
        addToDoList("tiga");
        addToDoList("empat");
        addToDoList("lima");

        viewShowToDoList();
        }
    // tampilan tambah to do list
    public static void viewAddToDoList(){
        System.out.println("Tambah To Do List");

        var todo =input("ToDo (X untuk batalakn)");
        if (todo.equals("x")){

        }else{
            addToDoList(todo);
        }
    }

    public static void testViewAddToDoList() {
        viewAddToDoList();

        showToDoList();
    }

    // tampilan hapus to do list
    public static void viewDeleteToDoList(){
        System.out.println("menghapus To Do List");

        var number =input("Masukan Nomor yang ingin dihapus (X untuk batalakn)");

        if(number.equals("x")){
            //batal
        }else{
            boolean success =deleteToDoList(Integer.valueOf(number));
            if(!success){
                System.out.println("gagal menghapus todo list "+number);
            }
        }
    }
    public static void testViewDeleteToDoList(){
        addToDoList("satu");
        addToDoList("dua");
        addToDoList("tiga");
        showToDoList();

        viewDeleteToDoList();

        showToDoList();
    }
}
