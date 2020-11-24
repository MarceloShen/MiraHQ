package OOPPPolymorphism;

public class ResizableCircle extends GeoCircle implements Resizable{
    public ResizableCircle(double radius){
        super(radius);
    }

    public String toString(){
        return "Resizable " + super.toString();
    }

    @Override
    public void resize(int percent){
        super.radius *= (percent/100.0);
    }
}