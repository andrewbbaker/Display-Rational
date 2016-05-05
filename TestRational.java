import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestRational {

	public static void main(String[] args) {
		Rational A [] = new Rational [10];
		Rational B [] = new Rational [A.length], C [] = new Rational [A.length];
		for (int i=0;i<A.length;i++){
			A[i]= new Rational ((int)(Math.random()*9+1), (int)(Math.random()*991), "A");
			B[i]= new Rational ((int)(Math.random()*9+1), (int)(Math.random()*9+1), "B");
		}
		
		JTextArea AText = new JTextArea(11, (int)Math.log(A.length)+10), BText = new JTextArea(11, (int)Math.log(A.length)+10), CText = new JTextArea(11, (int)Math.log(A.length)+14);
		
		ratsToTextArea (AText, A);
		ratsToTextArea (BText, B);
		
		JButton MixA = new JButton("Randomize A");
		MixA.addActionListener(new ActionListener() 
		{
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 for (int i=0;i<A.length;i++)
	        	 {
	     			A[i]= new Rational ((int)(Math.random()*9+1), (int)(Math.random()*9+1), "A");
	        	 }
	        	 ratsToTextArea (AText, A);
	        	 CText.setText(null);
	         }          
	      });
		JButton SortSmallFirst = new JButton("Sort smallest to largest");
		SortSmallFirst.addActionListener(new ActionListener() 
		{
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 if(!CText.getText().equals(""))
	        		 Arrays.sort(C, new RationalCompareSmallFirst());
	        	 if(!CText.getText().equals(""))
	        		 ratsAppendTextAreaName (CText, C);
	         }          
	      });
		JButton SortLargeFirst = new JButton("Sort Largest to smallest");
		SortLargeFirst.addActionListener(new ActionListener() 
		{
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 if(!CText.getText().equals(""))
	        		 Arrays.sort(C, new RationalCompareLargeFirst());
	        	 if(!CText.getText().equals(""))
	        		 ratsAppendTextAreaName (CText, C);
	         }          
		});
		
		JButton MixB = new JButton("Randomize B");
		MixB.addActionListener(new ActionListener() 
		{
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 for (int i=0;i<B.length;i++)
	     			B[i]= new Rational ((int)(Math.random()*9+1), (int)(Math.random()*9+1), "B");
	        	 ratsToTextArea (BText, B);
	        	 CText.setText(null);
	         }          
	      });
		
		JButton AaddB = new JButton("A plus B");
		AaddB.addActionListener(new ActionListener() 
		{
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 for (int i=0;i<B.length;i++)
	        		 C[i]=new Rational(A[i].add(B[i]),"" + A[i].toString() + " + " + B[i].toString());
	        	 ratsToTextAreaName (CText, C);
	         }          
	      });
		JButton AsubB = new JButton("A minus B");
		AsubB.addActionListener(new ActionListener() 
		{
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 for (int i=0;i<B.length;i++)
	     			C[i]=new Rational(A[i].sub(B[i]),"" + A[i].toString() + " - " + B[i].toString());
	        	 ratsToTextAreaName (CText, C);
	         }          
	      });
		
		JButton BsubA = new JButton("B minus A");
		BsubA.addActionListener(new ActionListener() 
		{
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 for (int i=0;i<B.length;i++)
	        		 C[i]=new Rational(B[i].sub(A[i]),"" + B[i].toString() + " - " + A[i].toString());
	        	 ratsToTextAreaName (CText, C);
	         }          
	      });
		JButton AmultB = new JButton("A times B");
		AmultB.addActionListener(new ActionListener() 
		{
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 for (int i=0;i<B.length;i++)
	        		 C[i]=new Rational(A[i].mult(B[i]),"" + A[i].toString() + " * " + B[i].toString());
	        	 ratsToTextAreaName (CText, C);
	         }          
	      });
		JButton AdivideB = new JButton("A divided by B");
		AdivideB.addActionListener(new ActionListener() 
		{
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 for (int i=0;i<B.length;i++)
	        		 C[i]=new Rational(A[i].divide(B[i]),"" + A[i].toString() + " / " + B[i].toString());
	        	 ratsToTextAreaName (CText, C);
	         }          
	      });
		JButton BdivideA = new JButton("B divided by A");
		BdivideA.addActionListener(new ActionListener() 
		{
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 for (int i=0;i<B.length;i++)
	        		 C[i]=new Rational(B[i].divide(A[i]),"" + B[i].toString() + " / " + A[i].toString());
	        	 ratsToTextAreaName (CText, C);
	         }          
	      });
		
		
		
		JButton Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener() 
		{
	         public void actionPerformed(ActionEvent e) 
	         {
	        	 System.exit(0);
	         }          
	      });
		
		JScrollPane AScPane = new JScrollPane(AText), BScPane = new JScrollPane(BText), CScPane = new JScrollPane(CText);
		JPanel APan = new JPanel(), BPan = new JPanel(), CPan = new JPanel(), Buttons = new JPanel();
		
		APan.add(AScPane);
		BPan.add(BScPane);
		CPan.add(CScPane);
		Buttons.add(MixA);
		Buttons.add(MixB);
		Buttons.add(SortSmallFirst);
		Buttons.add(SortLargeFirst);
		Buttons.add(AaddB);
		Buttons.add(AsubB);
		Buttons.add(BsubA);
		Buttons.add(AmultB);
		Buttons.add(AdivideB);
		Buttons.add(BdivideA);
		
		Buttons.add(Exit);
		
		JFrame JF = new JFrame();
		JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JF.add(APan, BorderLayout.LINE_START);
		JF.add(BPan, BorderLayout.CENTER);
		JF.add(CPan, BorderLayout.LINE_END);
		JF.add(Buttons, BorderLayout.PAGE_END);
		JF.pack();
		JF.setVisible(true);
	}
	
	public static void printRational (Rational[] Rat){
		for (int i=0;i<Rat.length;i++){
			System.out.println(Rat[i].getName() +"["+i+"]=" + (Rat[i].toString()));
		}
	}
	
	public static void printRationals (Rational[] Rat1, Rational [] Rat2, char operation){
		String Rat1Name=Rat1[0].getName();
		String Rat2Name=Rat2[0].getName();
		
		for (int i=0;i<Rat1.length;i++){
			System.out.println(Rat1Name +"["+i+"] " + operation + " " +Rat2Name +"["+i+"] = " + Rat1[i].chooseOperation(Rat2[i],  operation));
		}
	}
	
	public static void ratsToTextArea (JTextArea JTA, Rational [] Rats)
	{
		JTA.setText(null);
		for (int i=0;i<Rats.length-1;i++)
		{
			JTA.append((i+1) + ") " + Rats[i].toString());
			JTA.append("\n");
		}
		JTA.append(Rats.length + ") " + Rats[Rats.length-1].toString());	
	}
	public static void ratsToTextAreaName (JTextArea JTA, Rational [] Rats)
	{
		JTA.setText(null);
		for (int i=0;i<Rats.length-1;i++)
		{
			JTA.append(Rats[i].getName() + " = " + Rats[i].toString() + "\n");
		}
		JTA.append(Rats[Rats.length-1].getName() + " = " + Rats[Rats.length-1].toString());	
	}
	public static void ratsAppendTextArea (JTextArea JTA, Rational [] Rats)
	{
		JTA.append("\n");
		for (int i=0;i<Rats.length-1;i++)
		{
			JTA.append("\n");
			JTA.append((i+1) + ") " + Rats[i].toString());
			
		}
		JTA.append("\n" + Rats.length + ") " + Rats[Rats.length-1].toString());	
	}
	public static void ratsAppendTextAreaName (JTextArea JTA, Rational [] Rats)
	{
		JTA.append("\n\n");
		for (int i=0;i<Rats.length-1;i++)
		{
			JTA.append(Rats[i].getName() + " = " + Rats[i].toString() + "\n");
		}
		JTA.append(Rats[Rats.length-1].getName() + " = " + Rats[Rats.length-1].toString());		
	}

}

//Arrays.sort(a, new RationalCompare());