import javax.swing.JOptionPane;
public class DogGame{
   private static String name, input;
   private static int points, i=0;
 //This is the main method
   public static void main(String[] args) {
      name = JOptionPane.showInputDialog("What is your name?");
      JOptionPane.showMessageDialog(null, "Hello " + name + "! Welcome to dog petting simulator");
   	
      Ask();
      dogMeter(points);
      
      while(!input.equalsIgnoreCase("quit")){
         Ask();
         dogMeter(points);
      }
   }
 //This method asks the user if they wanna pet the dog
   public static String Ask(){
      input = JOptionPane.showInputDialog("Do you wanna pet the dog? \n Type yes or no. Type quit to exit");
      if (input.equalsIgnoreCase("yes")) {
         petDog(input);
      }
      else if (input.equalsIgnoreCase("no")) {
         dontPetDog(input);
      }
      else if (input.equalsIgnoreCase("quit")) {
         JOptionPane.showMessageDialog(null, "Doggo is sad that you are leaving :(");
         System.exit(0);
      }
      return input;
   }
 //This method adds 1 to a value that represents happiness
   public static String petDog(String Happiness) {
      while (input.equalsIgnoreCase("yes")) {
         i++;
         points = i;
         break;
      }
      JOptionPane.showMessageDialog(null,"You made puppo happy!");
      return Happiness;
   }
 //This method subtracts 1 to a value that represents sadness
   public static String dontPetDog(String Sadness) {
      while (input.equalsIgnoreCase("no")) {
         i--;
         points = i;
         break;
      }
      JOptionPane.showMessageDialog(null,"You make pupper sad D:<");
      return Sadness;
   }
 //This is gonna get wild	
   public static void dogMeter(int Feeling) {
   	if (points<0){
         JOptionPane.showMessageDialog(null,"your pupper is feeling sad! :(");
      }
      else if(points>=0 && points<10){
         JOptionPane.showMessageDialog(null,"your pupper is coming around");
      }
      else if(points>=11 && points<20){
         JOptionPane.showMessageDialog(null,"your doggy loves you!");
      }
      else if(points>=21 && points<30){
         JOptionPane.showMessageDialog(null,"your pup is overwhelmed with love!! :))"); 
      }
      else if (points==31) {
         JOptionPane.showMessageDialog(null,"your doggo is super into you but pup has to leave :(");
         System.exit(0);
      }
   }
}