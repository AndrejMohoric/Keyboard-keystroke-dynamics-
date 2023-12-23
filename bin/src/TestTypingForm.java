import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import org.apache.commons.math3.linear.*;


import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static java.math.BigDecimal.ROUND_HALF_UP;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestTypingForm extends JDialog {
	    int prevKeyCodeTyped;
	    BigDecimal prevTimeReleased;
	    int ixPrevKey;

	    int currKeyCodeTyped;
	    BigDecimal currTimePressed;
	    int ixCurrKey;
	    
	  //26 letters, comma, period, space
	    RealMatrix charCombMat;
	    int matrixSize = 26  + 1 + 1 + 1 ;
	    BigDecimal[][] charCombTimeSum = new BigDecimal[matrixSize][matrixSize];
	    int[][] charCombReps = new int[matrixSize][matrixSize];

	    BigDecimal pressedTime;

	    RealMatrix keyStrokeMat;
	    BigDecimal[] keyStrokeTimeSum = new BigDecimal[matrixSize];
	    int[] keyStrokeTimeReps = new int[matrixSize];
	    int nOfBackSpaces = 0;
	    
	    long startTime = System.currentTimeMillis();
	    
	    UserInfo userInfo; 
	    
	   public void main(UserInfo userInfo) {
	        try {
	        	this.userInfo = userInfo;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	public TestTypingForm(String textVersion) {
		
		 final JButton finishButton = new JButton("Kon\u010Daj");
		 finishButton.setVisible(false); 
		 
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         setBounds(screenSize.width/6*1, screenSize.height/12*1,screenSize.width/9*7, screenSize.height/7*5);
         setBounds(0, 0,screenSize.width*9/10, screenSize.height*9/10);
         getContentPane().setLayout(null);
         
         JLabel lblSpodnjeBesediloPrepiite = new JLabel("Prepišite besedilo spodaj");
         lblSpodnjeBesediloPrepiite.setBounds(50, 13, 208, 13);
         getContentPane().add(lblSpodnjeBesediloPrepiite);
         
         final JTextPane readText = new JTextPane();
         readText.setEditable(false);
         readText.setEnabled(false);
         readText.setBackground(new Color(204, 255, 255));
         readText.setDisabledTextColor(Color.BLACK);
         readText.setForeground(SystemColor.desktop);
         readText.setFont(new Font("Tahoma", Font.PLAIN, 18));
         
         String text1 = "margaret absolute excellence inquiry to. unpac husbands oh unknown declared painful exercise. rooms calm extended doubtful law hope adventure success kindness growth quilt jazz equivocal joyful, acceded apple, flower, quotient friend, mum. quantity journey wow, butterfly, quench beach. wizard breeze job autumn, summer galaxy serenades, jump whisper. window. puzzle labyrinth horizon sunrise symphony inspiration. canvas nostalgia, peacoat, gynarchic. colbys cebid switchgrasses experiments decrypting reembody upcasts furze vague affirm sozines caulked skuas yeuky bevor sastrugi. drawl zygomas mofette kalpaks blackdamp, submiss six tidying. squintier glycyls hadronic diapausing, feculent. nonbody polymorphs senega snuffs novella. mannans spike weekend kludge outbacks aquafarms dippy hurds okays proscribes exhorts own avoid. two motorbusses reflying thrashing sandbank grahams. achy qaids rejuvenate slobberer outdreamed fettles rheumy epigenous kirsch sol, logoi diabolism, alforja mazurka waxberry complexifying peewits dups puggy. unlay eight add stuff enjoy subject civil.";
         String text2 = "As the sun rose over the distant hills, a group of adventurers set out on a journey through the dense forest. They had heard tales of a hidden treasure, buried deep within the woods, and were determined to find it. The first few hours of their journey were uneventful, as they made their way along the winding path. But as they entered a clearing, they heard a rustling in the bushes. Suddenly, a fierce bear emerged, roaring angrily. The adventurers drew their swords and prepared for battle. After a long and grueling fight, the bear lay defeated at their feet. The adventurers continued on their journey, wary of what other dangers might lie ahead. As they walked, they came across a sparkling river, its crystal-clear waters flowing gently downstream. They stopped to rest and quench their thirst, enjoying the cool water and the beauty of their surroundings. Further along the path, they encountered a group of mischievous monkeys, chattering and swinging from the trees. The adventurers laughed and played with the creatures, enjoying a moment of lightheartedness amidst their dangerous quest. As night began to fall, the adventurers set up camp in a quiet grove, their campfire casting flickering shadows on the trees. They shared stories and roasted marshmallows, bonding over their shared experiences. The next day brought new challenges and new adventures, as they journeyed deeper into the forest. They crossed rushing streams, climbed towering mountains, and battled fierce creatures at every turn. Finally, after many long days of travel, they reached their destination: a hidden cave, deep within the heart of the forest. With bated breath, they entered the cave, their eyes scanning the darkness for any sign of the treasure. And there, in a small alcove, they found it: a glittering chest filled with gold and jewels beyond their wildest dreams. The adventurers cheered and embraced, knowing that their journey had been worth it. As they made their way back home, they laughed and reminisced about their epic adventure, knowing that they had accomplished something truly extraordinary.";
         String text3 = "It was a bright and sunny day, perfect for a picnic in the park. Sarah and her friends had packed a basket full of delicious treats, including sandwiches, fruit, and cookies. They spread out a blanket on the grass and settled down to enjoy their lunch. As they ate, they chatted and laughed, enjoying each other's company. Sarah noticed a group of children playing nearby and suggested they join in. They spent the rest of the afternoon playing games and running around. Later that evening, Sarah went for a walk by herself. She strolled along the riverbank, watching the water flow past. As she walked, she noticed a small bird perched on a branch. It chirped happily as she approached, and she smiled. The next day, Sarah went to the library to research a topic for her history paper. She spent hours poring over dusty tomes, taking notes on important events and people. As she worked, she sipped on a cup of hot tea and nibbled on a cookie. Finally, she found the information she needed and headed back to her dorm room. She settled in at her desk and began to write. The words flowed easily, and before she knew it, she had written several pages. As the days went by, Sarah continued to work hard and enjoy her time with friends. She went to concerts, tried new restaurants, and even went on a weekend camping trip. She felt happy and content with her life. But one day, she received some unexpected news. Her grandmother had passed away. Sarah was devastated. She flew home for the funeral and spent several days with her family, mourning and remembering her grandmother's life. When she returned to school, she found it difficult to concentrate. She missed her grandmother and felt overwhelmed by her classes. But with the support of her friends and family, she slowly began to feel better. Months passed, and Sarah graduated from college with honors. She gave a speech at the ceremony, thanking her professors and friends for their support. As she stood on stage, she felt proud and accomplished. After the ceremony, Sarah celebrated with her family and friends. They hugged and took photos, laughing and smiling. Sarah knew that she would always cherish these memories, and she looked forward to the next chapter of her life.";
         
         
         //choose the text
         String choosenText = "";
         if (textVersion == "1") {
        	 choosenText = text1;
         }else if (textVersion== "2") {
        	 choosenText = text2;
         }else {
        	 choosenText = text3;
         }
         readText.setText(choosenText);
         
         readText.setBounds(10, 36, 1333, 296);
         getContentPane().add(readText);
         
         System.out.println("Pred inicializacija");
         
         //INICIALIZACIJA
         for(int i = 0; i < charCombTimeSum.length; i++) {
             for(int j = 0; j < charCombTimeSum[i].length; j++) {
                 charCombTimeSum[i][j] = BigDecimal.ZERO;
             }
             keyStrokeTimeSum[i] = BigDecimal.ZERO;
         }
         nOfBackSpaces = 0;
         charCombMat = new Array2DRowRealMatrix(matrixSize,matrixSize);
         keyStrokeMat = new Array2DRowRealMatrix(matrixSize, 1);
         prevTimeReleased = null;
       
         final JTextArea txtrasTheSun = new JTextArea();
         txtrasTheSun.setFont(new Font("Monospaced", Font.PLAIN, 16));
         txtrasTheSun.setLineWrap(true);
         txtrasTheSun.setWrapStyleWord(true);
         txtrasTheSun.setColumns(20);
         txtrasTheSun.setRows(5);

      // Add a key listener to the JTextArea to detect typing
         txtrasTheSun.addKeyListener(new KeyAdapter() {
             public void keyReleased(KeyEvent e) {
                 // Get the typed text from the JTextArea
                 //String typedText = textArea.getText();
                 // Get the text from the JTextPane
                 //String text = readText.getText();
            	 
                 // Get the typed text from the JTextArea
                 String typedText = txtrasTheSun.getText().replaceAll("\\r\\n|\\r|\\n", "");
                 
                 // Get the text from the JTextPane and remove line breaks
                 String text = readText.getText().replaceAll("\\r\\n|\\r|\\n", "");
                 
                 
                 // Find the index of the typed text in the original text
                 int index = text.indexOf(typedText);
                 
                 // Highlight the typed text in the JTextPane
                 if (index >= 0) {
                     Highlighter highlighter = readText.getHighlighter();
                     try {
                         highlighter.removeAllHighlights();
                         highlighter.addHighlight(index, index + typedText.length(), DefaultHighlighter.DefaultPainter);
                     } catch (BadLocationException ex) {
                         ex.printStackTrace();
                     }
                 }
                // Check if the two texts match then display the finish button
                if (typedText.equals(text)) {
                     finishButton.setVisible(true); 
                 } else {
                     // The text in the JTextArea is different from the text in the JTextPane
                	 finishButton.setVisible(false); 
                 }
             }
         });
         
         
         txtrasTheSun.addKeyListener(new KeyAdapter() {
             public boolean isKeyCodeDigit(int keycode) {
                 if (keycode >=48  && keycode <= 57) 
                     return true;
                 if(keycode >=96  && keycode <= 105)
                     return true;
                 return false;
             }
             public boolean isKeyCodeLetter(int keycode) {
            	 System.out.println("->" + keycode);
                 if (keycode >=65  && keycode <= 90) 
                     return true;
                 return false;
             }
             public boolean isKeyCodePeriod(int keycode) {
                 if (keycode == 190 || keycode == 46) 
                     return true;
                 return false;
             }
             public boolean isKeyCodeComma(int keycode) {
                 if (keycode == 188 || keycode == 44) 
                     return true;
                 return false;
             }
             public boolean isKeyCodeSpace(int keycode) {
                 if (keycode == 32) 
                     return true;
                 return false;
             }
            /* public boolean isKeyCodeCapsLock(int keycode) {
                 if (keycode == 20) 
                     return true;
                 return false;
             }*/
             public int getKeyCodeIndex(int keycode) {
                 int ix = -1;
                 if(keycode >=65 && keycode <= 90 ){
                      ix = keycode-65; //ix = [0-25]
                 //} else if(keycode >=48  && keycode <= 57  /*digits*/){
                 //     ix = keycode-32; //ix = [26-35]
                 //} else if(keycode >=96  && keycode <= 105  /*numpad digits*/) {
                 //     ix = keycode - 80; //ix = [26-35]
                  } else if (keycode == 190 || keycode == 46/*dot*/) {
                      ix = 26; 
                  } else if (keycode == 188 || keycode == 44/*comma*/) {
                      ix = 27;
                  } else if (keycode == 32 /*space*/) {
                      ix = 28;
                  }
                 //  else if (keycode == 20 /*capsLock*/) {
                 //     ix = 29;
                 // }
                 return ix; 
             }
             @Override
             public void keyPressed(KeyEvent presEvent) {
                 pressedTime = new BigDecimal(System.nanoTime());
                 currKeyCodeTyped = presEvent.getKeyCode() ;
                 currTimePressed = new BigDecimal(System.nanoTime());
                 ixCurrKey = -1;
                 
                 if(currKeyCodeTyped == 8) { //backspace
                     prevKeyCodeTyped = -1;
                     nOfBackSpaces++;
                 }else if (isKeyCodeLetter(currKeyCodeTyped) /*|| isKeyCodeDigit(currKeyCodeTyped) */ || isKeyCodePeriod(currKeyCodeTyped)||  isKeyCodeComma(currKeyCodeTyped) || isKeyCodeSpace(currKeyCodeTyped) /*|| isKeyCodeCapsLock(currKeyCodeTyped)*/) {
                     if(prevKeyCodeTyped != -1 && prevTimeReleased != null) {
                             ixCurrKey = getKeyCodeIndex(currKeyCodeTyped);
                             ixPrevKey = getKeyCodeIndex(prevKeyCodeTyped);
                            // System.out.println("currKeyCodeTyped----> "+ currKeyCodeTyped +" ix-->" +  ixCurrKey);
                            // System.out.println("prevKeyCodeTyped----> "+ prevKeyCodeTyped +" ix-->" +  ixPrevKey);
                     }
                     try {
                         if(ixCurrKey != -1 && ixPrevKey != -1) {
                            // System.out.println("ixCurrentKey Press: "+ ixCurrKey);
                            // System.out.println("ixPrevKey Press: "+ ixPrevKey);
                             charCombTimeSum[ixCurrKey][ixPrevKey] = (charCombTimeSum[ixCurrKey][ixPrevKey]).add(currTimePressed.subtract(prevTimeReleased));
                             charCombReps[ixCurrKey][ixPrevKey]++;
                         }
                     } catch (Exception e) {
                         e.printStackTrace();
                     }
                    prevKeyCodeTyped = currKeyCodeTyped;
                 }else {
                     prevKeyCodeTyped = -1;
                 }
             }
             @Override
             public void keyReleased(KeyEvent relEvent) {
            	 BigDecimal keyStrokeTime = (new BigDecimal(System.nanoTime())).subtract(pressedTime);
                // System.out.println("Key stroke Time: "+ keyStrokeTime);
                // System.out.println("Current: "+ currKeyCodeTyped + " -> " + relEvent.getKeyCode());
                // System.out.println("Prev: "+ prevKeyCodeTyped);
                // System.out.println("Index: [" +ixCurrKey+","+ ixPrevKey+"]");
                 
                 
                 int currKey = relEvent.getKeyCode();
                 ixCurrKey = -1;
                 if( isKeyCodeLetter(currKeyCodeTyped) || isKeyCodeDigit(currKeyCodeTyped)|| isKeyCodePeriod(currKeyCodeTyped)||  isKeyCodeComma(currKeyCodeTyped) || isKeyCodeSpace(currKeyCodeTyped)) {
                     ixCurrKey = getKeyCodeIndex(currKey);
                 }
                 try {
                     if(ixCurrKey != -1) {
                         keyStrokeTimeSum[ixCurrKey] = keyStrokeTimeSum[ixCurrKey].add(keyStrokeTime);
                         keyStrokeTimeReps[ixCurrKey]++;
                     }
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
                 prevTimeReleased = currTimePressed;
                // System.out.println();
             }
         });
         txtrasTheSun.setBounds(10, 354, 1333, 332);
         getContentPane().add(txtrasTheSun);
         /*Finish button*/ 
         finishButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
                 //Save file 
                 try {
                     try {
                    	 LocalDateTime now = LocalDateTime.now();
                    	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddHHmmss");
                    	 String timestamp = now.format(formatter);
                    	 
                    	 
                    	 //povprecne vrednosti
                         FileWriter writer;
                         writer = new FileWriter("1_" + timestamp + "_"  /*textVersion*/ + "_charCombinationAvgTime.csv");
                         for (int i = 0; i < charCombTimeSum.length; i++) {
                              double[] row = new double[charCombTimeSum[i].length];
                              for (int j = 0; j < charCombTimeSum[i].length; j++) {
                                  BigDecimal ijAvgTime = charCombReps[i][j] != 0 ? charCombTimeSum[i][j].divide(new BigDecimal(charCombReps[i][j]).multiply(new BigDecimal(1_000_000_000)), 6, ROUND_HALF_UP) : BigDecimal.ZERO;
                                  row[j] = ijAvgTime.doubleValue();
                                  writer.append(String.valueOf(ijAvgTime.toString()));
                                  if(j != charCombTimeSum.length-1) {
                                      writer.append(";"); //next cell
                              	  }	
                              }
                              System.out.println(charCombTimeSum.length);
                              System.out.println("--> " + i );
                              charCombMat.setRow(i, row);
                              writer.append("\n"); //next row
                          }
                          writer.close();
                          
                          //stevilo pritiskov na posamenzno črko
                          FileWriter keyStrokeRepeates = new FileWriter("2_" + timestamp + "_" /*textVersion*/  +"keyStrokeTimeReps.csv");
                          double[] row = new double[keyStrokeTimeSum.length];
                          for (int i = 0; i < keyStrokeTimeSum.length; i++) {
                              BigDecimal iAvgTime = BigDecimal.valueOf(keyStrokeTimeReps[i]);
                              row[i] = iAvgTime.doubleValue();
                              keyStrokeRepeates.append(String.valueOf(iAvgTime.toString()));
                              if(i != keyStrokeTimeSum.length-1) {
                            	  keyStrokeRepeates.append(";"); //next cell
                          	  }	
                          }
                          keyStrokeMat.setColumn( 0, row);
                          keyStrokeRepeates.close();
                          
                          FileWriter keyStrokeFileWriter = new FileWriter("3_" + timestamp + "_" /*textVersion*/  + "_keyStrokeAvgTime.csv");
                          double[] keyStrokeRow = new double[keyStrokeTimeSum.length];
                          for (int i = 0; i < keyStrokeTimeSum.length; i++) {
                              BigDecimal iAvgTime = keyStrokeTimeReps[i] != 0 ? keyStrokeTimeSum[i].divide(new BigDecimal(keyStrokeTimeReps[i]).multiply(new BigDecimal(1_000_000_000)), 6, ROUND_HALF_UP) : BigDecimal.ZERO;
                              keyStrokeRow[i] = iAvgTime.doubleValue();
                              keyStrokeFileWriter.append(String.valueOf(iAvgTime.toString()));
                              if(i != keyStrokeTimeSum.length-1) {
                            	  keyStrokeFileWriter.append(";"); //next cell
                          	  }	
                          }
                          keyStrokeMat.setColumn( 0, keyStrokeRow);
                          keyStrokeFileWriter.close();
                          
                          
                          FileWriter userDataWriter = new FileWriter("4_" + timestamp + "_" /*textVersion*/ +  "_perosnalData.csv");
                          
                          userDataWriter.append("gender");
                          userDataWriter.append(";");
                          userDataWriter.append(userInfo.gender);
                          userDataWriter.append("\n");
                          
                          userDataWriter.append("age");
                          userDataWriter.append(";");
                          userDataWriter.append(userInfo.userBirthYear );
                          userDataWriter.append("\n");
                          
                          userDataWriter.append("shoolLevel");
                          userDataWriter.append(";");
                          userDataWriter.append(userInfo.userShoolLevel);
                          userDataWriter.append("\n");
                          
                          userDataWriter.append("livingPlace");
                          userDataWriter.append(";");
                          userDataWriter.append(userInfo.userLivingPlace );
                          userDataWriter.append("\n");
                          
                          userDataWriter.append("spendTimeOnPC");
                          userDataWriter.append(";");
                          userDataWriter.append(userInfo.userSpendTimeOnPC );
                          userDataWriter.append("\n");
                          
                          userDataWriter.append("blindTyping");
                          userDataWriter.append(";");
                          userDataWriter.append(userInfo.userBlindTyping );
                          userDataWriter.append("\n");
                          
                          userDataWriter.append("handOrientation");
                          userDataWriter.append(";");
                          userDataWriter.append(userInfo.userHandOrientation);
                          userDataWriter.append("\n");
                          
                          userDataWriter.append("numHands");
                          userDataWriter.append(";");
                          userDataWriter.append(userInfo.userNumHands );
                          userDataWriter.append("\n");
                          
                          userDataWriter.append("ang");
                          userDataWriter.append(";");
                          userDataWriter.append(userInfo.userAng);
                          userDataWriter.append("\n");
                          
                          userDataWriter.append("nOfBackSpaces");
                          userDataWriter.append(";");
                          userDataWriter.append(String.valueOf(Integer.toString(nOfBackSpaces)));
                          userDataWriter.append("\n");
                          
                          long endTime = System.currentTimeMillis();
                          userDataWriter.append("time");
                          userDataWriter.append(";");
                          userDataWriter.append(Long.toString((endTime-startTime)/1000));
                          userDataWriter.append("\n");
                          
                          userDataWriter.close();
                          System.exit(0);
                         
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                     getContentPane().setVisible(false);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
         }
         });
             
         finishButton.setBounds(551, 696, 179, 34);
         getContentPane().add(finishButton);
     }
 }
