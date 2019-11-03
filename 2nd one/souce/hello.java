import javax.swing.*;

class hello{
    public static void main(String[] args){
        String fn=JOptionPane.showInputDialog("Enter");
        String sn=JOptionPane.showInputDialog("Enter");
        JOptionPane.showMessageDialog(null, fn+sn,"Hello", JOptionPane.PLAIN_MESSAGE);


    }
}