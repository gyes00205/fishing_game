package finalproject;
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
public class Game extends JFrame implements ActionListener{
	
	final int fishNumber = 30;
	int sec = 30;
	int score = 0;
	int finalScore = 0;
	int check = 0;
	Timer startTimer;
	Timer hookcontrol_horizontal;
	Timer fish_move;
	Timer collision_detecter;
	boolean hookDown = false;
	boolean taken_over = true;
	
	JButton fishingButton = new JButton("Take");
	JButton startButton = new JButton("Start");
	JButton restartButton = new JButton("Restart");
	JButton checkButton = new JButton("OK");
	JLabel timeLabel = new JLabel("Time: "+score);
	JLabel scoreLabel = new JLabel("Score: ");
	JLabel finalScoreLabel = new JLabel();
	JLabel highestScoreLabel = new JLabel();
	ImageIcon fisherIcon = new ImageIcon("bin//fishing.png");
	JLabel fisherLabel =new JLabel();
	ImageIcon hookIcon = new ImageIcon("bin//hook.png");
	JLabel hookJLabel = new JLabel();
	ImageIcon underwaterIcon = new ImageIcon("bin//underwater.jpg");
	JLabel backgroundLabel = new JLabel();
	Fish[] shark = new Fish[fishNumber];
	ImageIcon sharkIcon = new ImageIcon("bin//shark.png");
	ImageIcon greenfishIcon = new ImageIcon("bin//greenfish.png");
	ImageIcon sharkflipIcon = new ImageIcon("bin//shark_flip.png");
	ImageIcon greenfishflipIcon = new ImageIcon("bin//greenfish_flip.png");
	//Fish[] shark = new Fish[fishNumber];
	ImageIcon boatIcon = new ImageIcon("bin//boat.png");
	JLabel boatLabel = new JLabel();
	Image img_sharkImage =  sharkIcon.getImage();
	Image img_sharkflipImage =  sharkflipIcon.getImage();
	Image img_greenfishImage =  greenfishIcon.getImage();
	Image img_greenfishflipImage =  greenfishflipIcon.getImage();
	int position;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game gameWindow = new Game();
		gameWindow.setVisible(true);
	}
	
	public Game() {
		setSize(1000, 630);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new CheckOnExit());
		this.setLocationRelativeTo(null);
		

		
		fishingButton.addActionListener(this);
		fishingButton.setLocation(850, 500);
		fishingButton.setSize(100, 50);
		fishingButton.setFont(new Font("SansSerif",Font.BOLD ,20));
		this.add(fishingButton);
		fishingButton.setVisible(false);
		
		
		startButton.addActionListener(this);
		startButton.setLocation(850, 400);
		startButton.setSize(100, 50);
		startButton.setFont(new Font("SansSerif",Font.BOLD ,20));
		this.add(startButton);
		
		restartButton.addActionListener(this);
		restartButton.setLocation(850, 300);
		restartButton.setSize(100, 50);
		restartButton.setFont(new Font("SansSerif",Font.BOLD ,18));
		this.add(restartButton);
		restartButton.setVisible(false);
		
		checkButton.addActionListener(this);
		checkButton.setSize(180, 80);
		checkButton.setFont(new Font("SansSerif",Font.BOLD ,18));
		
		timeLabel.setLocation(850, 50);
		timeLabel.setSize(150, 50);
		timeLabel.setFont(new Font("SansSerif",Font.BOLD ,20));
		timeLabel.setLayout(null);
		this.add(timeLabel);
		
		
		scoreLabel.setLocation(850, 150);
		scoreLabel.setSize(150, 50);
		scoreLabel.setFont(new Font("SansSerif",Font.BOLD ,20));
		scoreLabel.setLayout(null);
		this.add(scoreLabel);
		
		finalScoreLabel.setSize(150, 50);
		finalScoreLabel.setFont(new Font("SansSerif",Font.BOLD ,20));
		
		highestScoreLabel.setSize(150, 50);
		highestScoreLabel.setFont(new Font("SansSerif",Font.BOLD ,20));
		
		
		img_sharkImage = img_sharkImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		
		img_sharkflipImage = img_sharkflipImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		
		img_greenfishImage = img_greenfishImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		
		img_greenfishflipImage = img_greenfishflipImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		
		sharkIcon.setImage(img_sharkImage);
		greenfishIcon.setImage(img_greenfishImage);
		sharkflipIcon.setImage(img_sharkflipImage);
		greenfishflipIcon.setImage(img_greenfishflipImage);
		for(int i=0; i<fishNumber; i++) {
			Random rand = new Random();
			shark[i] = new Fish();
			shark[i].offset_X = rand.nextInt(3)+1;
			if(rand.nextInt(3)%2==0) {
				shark[i].setIcon(sharkIcon);
				shark[i].offset_X = rand.nextInt(4)+2;
				shark[i].setLocation(rand.nextInt(750),rand.nextInt(199)+300);
			}
			else {
				shark[i].setIcon(greenfishIcon);
				shark[i].offset_X = rand.nextInt(2)+1;
				shark[i].setLocation(rand.nextInt(750),rand.nextInt(200)+250);
			}
			//shark[i].setIcon(sharkIcon);
			;
			shark[i].weight = shark[i].getY()/10;
			shark[i].setSize(50,50);
			shark[i].setLayout(null);
			this.add(shark[i]);
		}
		

		Image img1 = hookIcon.getImage();
		img1 = img1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		hookIcon.setImage(img1);
		hookJLabel.setLocation(200,150);
		hookJLabel.setSize(100,100);
		hookJLabel.setIcon(hookIcon);
		hookJLabel.setLayout(null);
		this.add(hookJLabel);
		
		
		Image img = boatIcon.getImage();
		img = img.getScaledInstance(200, 150, Image.SCALE_DEFAULT);
		boatIcon.setImage(img);
		boatLabel.setIcon(boatIcon);
		boatLabel.setLocation(200, 100);
		boatLabel.setSize(200, 150);
		boatLabel.setLayout(null);
		this.add(boatLabel);
		
		
		Image backimg = underwaterIcon.getImage();
		backimg = backimg.getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
		underwaterIcon.setImage(backimg);
		backgroundLabel.setIcon(underwaterIcon);
		backgroundLabel.setLocation(0, 0);
		backgroundLabel.setSize(1000, 600);
		backgroundLabel.setLayout(null);
		this.add(backgroundLabel);
		
		this.setLayout(null);
	}
	

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Start") {
			System.out.println("Start");
			startButton.setText("Pause");
			fishingButton.setVisible(true);
			if(startTimer==null) {
				System.out.println("Timer starts");
				restartButton.setVisible(true);
				startTimer = new Timer();
				startTimer.scheduleAtFixedRate(new StartTask(), 1000, 1000);
				timeLabel.setText("Time: "+sec);
				hookcontrol_horizontal = new Timer();
				hookcontrol_horizontal.scheduleAtFixedRate(new HookControl(),0,10);
				fish_move = new Timer();
				fish_move.scheduleAtFixedRate(new FishControl(), 0, 5);//fish move from left to right
				collision_detecter = new Timer();
				collision_detecter.scheduleAtFixedRate(new CollisionControl(), 0, 1);
			}
		}
		else if(e.getActionCommand()=="Pause") {
			System.out.println("Pause");
			startButton.setText("Start");
			fishingButton.setVisible(false);
		}
		else if (e.getActionCommand()=="Take") {
			System.out.println("Take");
			System.out.println("hookDown: "+hookDown);
			System.out.println("hook.y: "+hookJLabel.getY());
			if(!hookDown) {
				hookDown = true;
				taken_over = false;
				position  = hookJLabel.getY();
				System.out.println("hook.y: "+hookJLabel.getY()+"offset_Y: "+offset_Y);
			}
		}
		else if (e.getActionCommand()=="Restart") {
			/*this.setVisible(false);
			this.dispose();
			Game gameWindow = new Game();
			gameWindow.setVisible(true);*/
			if(!(startTimer == null)) {
				startTimer.cancel();
				hookcontrol_horizontal.cancel();
				fish_move.cancel();
				collision_detecter.cancel();
				startTimer.purge();
				hookcontrol_horizontal.purge();
				fish_move.purge();
				collision_detecter.purge();
				
				fishingButton.setVisible(false);
				restartButton.setVisible(false);
				startButton.setVisible(true);
				
				
				
				boatLabel.setLocation(200, 100);
				hookJLabel.setLocation(200,150);
				for(int i=0; i<fishNumber; i++) {
					shark[i].setVisible(false);
				}
				for(int i=0; i<fishNumber; i++) {
					Random rand = new Random();
					
					shark[i].offset_X = rand.nextInt(3)+1;
					if(rand.nextInt(3)%2==0) {
						shark[i].setIcon(sharkIcon);
						shark[i].offset_X = rand.nextInt(4)+2;
						shark[i].setLocation(rand.nextInt(750),rand.nextInt(199)+300);
					}
					else {
						shark[i].setIcon(greenfishIcon);
						shark[i].offset_X = rand.nextInt(2)+1;
						shark[i].setLocation(rand.nextInt(750),rand.nextInt(200)+250);
					}
					//shark[i].setIcon(sharkIcon);
					shark[i].weight = shark[i].getY()/10;
					shark[i].setSize(50,50);
					shark[i].setLayout(null);
					shark[i].setVisible(true);
					shark[i].hooked = false;
				}
				
				check = 0;
				score = 0;
				scoreLabel.setText("Score: "+score);
				sec = 30;
				timeLabel.setText("Time: "+sec);
				startButton.setText("Start");
				startTimer = null;
			}
		}
	}
	private class StartTask extends TimerTask {
		public void run() {
			if(sec>0&&startButton.getText()=="Pause") {
				sec--;
				timeLabel.setText("Time: "+sec);
			}
			else if(sec == 0){
				if(check == 0) {
					check = 1;
					if(finalScore < score) finalScore = score;
					startButton.setVisible(false);
					fishingButton.setVisible(false);
					
					JFrame endframe = new JFrame();
					endframe.setLayout(new FlowLayout());
					endframe.setSize(300, 120);
					endframe.setLocation(630, 400);
					highestScoreLabel.setText("Your Highest Score: " + finalScore);
					finalScoreLabel.setText("Your Score: " + score);
					endframe.add(finalScoreLabel);
					endframe.add(highestScoreLabel);	
					endframe.setVisible(true);
				}
			}
		}
	}
	
	private int offset_X = 2;
	private int offset_Y = 2;
//	private int shark_offset_X = 2;
	private class HookControl extends TimerTask
	{
		public void run()
		{
			if(sec>0&&startButton.getText()=="Pause"&&!hookDown) //hook move horizontal
			{
				hookJLabel.setLocation(hookJLabel.getX()+offset_X,hookJLabel.getY());
				boatLabel.setLocation(hookJLabel.getX(), 100);
				if(hookJLabel.getX() >= 800||hookJLabel.getX() <= 50)
					offset_X = offset_X*-1;			
			}
			if(sec>0&&startButton.getText()=="Pause"&&!taken_over) //hook move vertical
			{
				hookJLabel.setLocation(hookJLabel.getX(),hookJLabel.getY()+offset_Y);
				if(hookJLabel.getY() >= 500)
					offset_Y = offset_Y*-1;
				if(hookJLabel.getY() < position)
				{
					offset_Y = 2;
					System.out.println(hookJLabel.getY()+" , "+position);
					hookJLabel.setLocation(hookJLabel.getX(),position);//adjust position to original
					System.out.println(hookJLabel.getY()+" , "+position);
					taken_over = true;
					hookDown = false;
					for(int i=0; i<fishNumber; i++) {
						if(shark[i].hooked && shark[i].isVisible())//if fish is hooked above water 
						{
							shark[i].setVisible(false);//disappeared
							score += shark[i].weight;
							scoreLabel.setText("Score: "+score);
							System.out.println(hookJLabel.getY()+" , "+position);
							
							if(shark[i].getIcon()==sharkflipIcon || shark[i].getIcon()==sharkIcon) {
								Random rand = new Random();
								shark[i].setIcon(sharkIcon);
								shark[i].offset_X = rand.nextInt(4)+2;
								shark[i].setLocation(rand.nextInt(750),rand.nextInt(199)+300);
							}
							else {
								Random rand = new Random();
								shark[i].setIcon(greenfishIcon);
								shark[i].offset_X = rand.nextInt(2)+1;
								shark[i].setLocation(rand.nextInt(750),rand.nextInt(200)+250);
							}
							shark[i].hooked = false;
							shark[i].setVisible(true);
						}
					}
					
				}
					
			}
		}
	}
	private class FishControl extends TimerTask{
		public void run()
		{
			if(sec>0&&startButton.getText()=="Pause")
			{
				for(int i=0;i<fishNumber;i++) {
					if(!shark[i].hooked) {
						shark[i].setLocation(shark[i].getX()+shark[i].offset_X, shark[i].getY());
						if(shark[i].getX()<=0)
						{
							shark[i].offset_X = shark[i].offset_X*-1;
							if(shark[i].getIcon()==sharkflipIcon) {
								shark[i].setIcon(sharkIcon);
							}
							if(shark[i].getIcon()==greenfishflipIcon) {
								shark[i].setIcon(greenfishIcon);
							}
						}
						else if(shark[i].getX()>=800) {
							shark[i].offset_X = shark[i].offset_X*-1;
							if(shark[i].getIcon()==sharkIcon) {
								shark[i].setIcon(sharkflipIcon);
							}
							if(shark[i].getIcon()==greenfishIcon) {
								shark[i].setIcon(greenfishflipIcon);
							}
						}
					}
					//sharkIcon.setImage(img_sharkImage);
					//greenfishIcon.setImage(img_greenfishImage);
					else {
						shark[i].setLocation(shark[i].getX(),hookJLabel.getY()); //stick to the hook
					}
				}
				
			}
		}
	}
	private class CollisionControl extends TimerTask{
		public void run() //detect whether is hooked or not per ten ms
		{
			if(sec>0&&startButton.getText()=="Pause")
			{
				for(int i=0;i<fishNumber;i++) {
					shark[i].hooked = collision(hookJLabel, shark[i]);
				}
				 
			}
		}
	}
	public boolean collision(JLabel a,Fish b)
	{
		Rectangle a1 = new Rectangle(a.getX()+a.getWidth()/4, a.getY()+a.getHeight()/4, a.getWidth()/2, a.getHeight()/2);
		Rectangle b1 = new Rectangle(b.getX()+b.getWidth()/4, b.getY()+b.getHeight()/4, b.getWidth()/2, b.getHeight()/2);
		if(a1.intersects(b1)) //if hooked keep true
		{
			if(hookJLabel.getY() > position && b.isVisible()) {
				offset_Y=-2;
			}
			
			return true;
		}
		else {
			return false;
		}
		
	}
}
