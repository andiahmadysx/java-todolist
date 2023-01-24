public class PreBuild {
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
     viewShowTodoList();
    }
    // BUSINESS LOGIC
    /**
     * Menampilkan Todo List
     */
    public static void showTodoList(){
       for (var i = 0; i < model.length; i++){
           String todo = model[i];
           var no = i + 1;

           if(todo != null){
               System.out.println(no + ". " + todo);
           }
       }
    }

//    public static void testShowTodoList() {
//        model[0] = "Belajar Java Dasar";
//        model[1] = "Membuat Aplikasi Todo List";
//        showTodoList();
//    }
    
    /**
     * Menambah Todo ke List
     */
    public static void addTodoList(String todo){
    // Cek apakah model penuh?
        var isFull = true;
        for (var i = 0; i < model.length; i++){
            if(model[i] == null){
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }

    // Jika isFull, kita resize ukuran array 2x lipat

        if(isFull){
            var temporary = model;
            model = new String[model.length*2];

            for (int i = 0; i < temporary.length; i++) {
                model[i] = temporary[i];
            }
        }

    // Tambahkan ke posisi yang data array nya null
        for (var i = 0; i < model.length; i++){
            if (model[i] == null ){
                model[i] = todo;
                break;
            }
        }

    }

//    public static void testAddTodoList() {
//
//        for (int i = 1; i < 25; i++) {
//
//            addTodoList("Contoh todo ke. " + i );
//
//        }
//
//        showTodoList();
//
//    }

    /**
     * Menghapus Todo dari List
     */
    public static boolean removeTodoList(Integer number){
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length ; i++) {
                if (i == model.length - 1){
                    model[i] = null;
                } else {
                model[i] = model[i + 1];
                }
            }
            return true;
        }

    }

//    public static void testRemoveTodoList(){
//        addTodoList("Satu");
//        addTodoList("Dua");
//        addTodoList("Tiga");
//        addTodoList("Empat");
//        addTodoList("Lima");
//
//        var result = removeTodoList(20);
//        System.out.println(result);
//
//        result = removeTodoList(7);
//        System.out.println(result);
//
//        result = removeTodoList(2);
//        System.out.println(result);
//
//        showTodoList();
//    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

//    public static void testInput(){
//        var name = input("Nama");
//        System.out.println("Hi " + name);
//
//        var channel = input("Github");
//        System.out.println(channel);
//    }

    // VIEW
    /**
     * Menampilkan view Todo List
     */
    public static void viewShowTodoList(){

        while (true){

            System.out.println("TODOLIST");

            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. keluar");

            var input = input("Pilih");

            if (input.equals("1")){
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }
//    public static void testViewShowTodoList(){
//        addTodoList("Satu");
//        addTodoList("Dua");
//        addTodoList("Tiga");
//        addTodoList("Empat");
//        addTodoList("Lima");
//        viewShowTodoList();
//    }

    /**
     * Menampilkan view menambahkan Todo List
     */
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")){
            // Batal
        } else {
            addTodoList(todo);
        }
    }

//    public static void testViewAddTodoList(){
//        addTodoList("Satu");
//        addTodoList("Dua");
//
//       viewAddTodoList();
//       showTodoList();
//    }

    /**
     * Menampilkan view menghapus Todo List
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");
        var number = input("Nomor yang Dihapus (x Jika Batal)");

        if (number.equals("x")){
            // Batal
        } else {
           boolean success =  removeTodoList(Integer.valueOf(number));
           if (!success){
               System.out.println("Gagal menghapus todolist : " + number);
           }
        }
    }

//    public static void testViewRemoveTodoList(){
//        addTodoList("Satu");
//        addTodoList("Dua");
//        addTodoList("Tiga");
//
//        showTodoList();
//
//        viewRemoveTodoList();
//
//        showTodoList();
//    }
}
