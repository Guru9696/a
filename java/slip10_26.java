

 abstract class Duck {
  FlyBehaviour flyBehaviour;
  QuackBehaviour quackBehaviour;
  public Duck() {
  }

  public abstract void display();

  public void performFly() {
    flyBehaviour.fly();
  }

  public void performQuack() {
    quackBehaviour.quack();
  }
  public void swim() {
    System.out.println("All ducks float, even decoys!");
  }
  public void setFlyBehaviour(FlyBehaviour fb) {
    flyBehaviour = fb;
  }
  public void setQuackBehaviour(QuackBehaviour qb) {
    quackBehaviour =  qb;
  }
}


 class MallardDuck extends Duck {

  public MallardDuck() {
    quackBehaviour = new Quack();
    flyBehaviour = new FlyWithWings();
  }

  public void display() {
    System.out.println("I'm a real Mallard duck");
  }
}

 class ModolDuck extends Duck {
  // public ModelDuck() {
     public ModolDuck() {
    flyBehaviour = new FlyNoWay();
    quackBehaviour = new Quack();
  }

  public void display() {
    System.out.println("I'm a model duck");
  }
}


 interface FlyBehaviour {
  public void fly();
}


 class FlyWithWings implements FlyBehaviour {
  public void fly() {
    System.out.println("I'm flying!!");
  }
}


 class FlyNoWay implements FlyBehaviour {
  public void fly() {
    System.out.println("I can't fly");
  }
}


class FlyRocketPowered implements FlyBehaviour {
  public void fly() {
    System.out.println("I'm flying with a rocket!");
  }
}


 interface QuackBehaviour {
  // public void quack() {
  public void quack() ;
}


 class Quack implements QuackBehaviour {
  public void quack() {
    System.out.println("Quack");
  }
}


 class MuteQuack implements QuackBehaviour {
  public void quack() {
    System.out.println("<< Silence >>");
  }
}


 class Squeak implements QuackBehaviour {
  public void quack() {
    System.out.println("Squeak");
  }
}

// MiniDuckSimulator.Java
// public class slip10 {
//   public static void main(String[] args) {
//     Duck mallard = new MallardDuck();
//     mallard.performQuack();
//     mallard.performFly();
//   }
// }

public class slip10_26 {
  public static void main(String[] args) {
    Duck mallard = new MallardDuck();
    mallard.performQuack();
    mallard.performFly();
    // Duck model = new ModelDuck();
    Duck model = new ModolDuck();
    model.performFly();
    model.setFlyBehaviour(new FlyRocketPowered());
    model.performFly();
  }
}
