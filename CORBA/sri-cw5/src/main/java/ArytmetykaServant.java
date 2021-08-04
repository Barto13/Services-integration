import ArytmetykaPackage.DzieleniePrzezZero;

public class ArytmetykaServant extends _ArytmetykaImplBase{

    public double s1, s2, wynik = 0;

    @Override
    public double s1(){
        return s1;
    }

    @Override
    public void s1(double newS1){
        s1 = newS1;
    }

    @Override
    public double s2(){
        return s2;

    }

    @Override
    public void s2(double newS2){
        s2 = newS2;
    }

    @Override
    public double wynik(){
        return wynik;
    }

    @Override
    public void wynik(double newWynik){

    }

    @Override
    public void suma(){
        wynik = s1 + s2;
    }

    @Override
    public void roznica(){
        wynik = s1 - s2;
    }

    @Override
    public void iloczyn(){
        wynik = s1*s2;
    }

    @Override
    public void iloraz(){
        try{
            wynik = s1/s2;
        } catch (ArithmeticException e){
            System.out.println("Cannot divide by 0 !");
        }
    }
}
