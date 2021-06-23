public class Main {

    public static void main(String[] args) {

        Lager lager = new Lager(10);
        int atikelNr = 1111;
        String art = "a";
        for (int i = 0; i < 10; i++) {
            lager.legeAnArtikel(new Artikel(atikelNr++ , art , i , (i+1) * 20 - 1.0));
            art += "h";
        }

        System.out.println(lager.toString());
        lager.getSorted((artikel, artikel2) -> artikel.getPreis() < artikel2.getPreis());
        System.out.println(lager.toString());
    }
}
