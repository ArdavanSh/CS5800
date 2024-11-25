public class VendingMachineDriver {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        // Add snacks
        vm.addSnack(new Snack("Coke", 1.50, 5));
        vm.addSnack(new Snack("Pepsi", 1.50, 5));
        vm.addSnack(new Snack("Cheetos", 1.00, 5));
        vm.addSnack(new Snack("Doritos", 1.00, 5));
        vm.addSnack(new Snack("KitKat", 0.75, 5));
        vm.addSnack(new Snack("Snickers", 0.75, 1));

        // Set up chain of responsibility
        SnackDispenseHandler cokeHandler = new CokeDispenseHandler();
        SnackDispenseHandler pepsiHandler = new PepsiDispenseHandler();
        SnackDispenseHandler cheetosHandler = new CheetosDispenseHandler();
        SnackDispenseHandler doritosHandler = new DoritosDispenseHandler();
        SnackDispenseHandler kitkatHandler = new KitKatDispenseHandler();
        SnackDispenseHandler snickersHandler = new SnickersDispenseHandler();

        cokeHandler.setNextHandler(pepsiHandler);
        pepsiHandler.setNextHandler(cheetosHandler);
        cheetosHandler.setNextHandler(doritosHandler);
        doritosHandler.setNextHandler(kitkatHandler);
        kitkatHandler.setNextHandler(snickersHandler);

        vm.setSnackDispenseHandler(cokeHandler);

        //buy a Snickers
        System.out.println("\n--- Buying a Snickers ---");
        vm.selectSnack("Snickers");
        vm.insertMoney(1.00);

        //  buy another Snickers
        System.out.println("\n--- Buying another Snickers ---");
        vm.selectSnack("Snickers");
        vm.insertMoney(1.00);

        // Buy a Coke
        System.out.println("\n--- Buying a Coke ---");
        vm.selectSnack("Coke");
        vm.insertMoney(2.00);

        // a snack that doesn't exist
        System.out.println("\n--- Buying an unknown snack ---");
        vm.selectSnack("MarsBar");
        vm.insertMoney(1.00);
    }
}
