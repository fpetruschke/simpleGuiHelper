# simpleGuiHelper

## About
SimpleGuiHelper is an attempt for easing the creation of guis.  
For me as a java beginner it was pretty hard to get a gui look like I wanted it to.  
I almost get how the whole java layout manager ish works - but it's still a long way to go.  

The projects aims to be a little 'framework' for setting up a gui.  
Use the GuiHelper for placing your content into a gui is to adjust the configuration of MainFrame, MenuBar and Cards.  


## Requirements
- You need to have Java 1.7 installed.  
- import Project into your workspace  


## Getting started

* Run the project with its example cards to see how MainFrame, MenuBar and Cards work.
* Configure the mainFrame, MenuBar and single cards to your needs
* For the content of your cards you can use any LayoutManager you want as long as you place it on the returned JPanel.

### creating your own card

* create a class with the name of your card inside of the "cards"-package  
* create a public function create(), which will return a JPanel that contains your card content  
* Example (containing an eventHandler for switching cards):  

```

public class AboutCard {

	public JPanel create() {
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        JButton backBtn = new JButton("zurück");
        backBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	new CardSwitcher(CardstackSetup.getCards(), CardstackSetup.STARTCARD);
		    }
		});
        card.add(backBtn, BorderLayout.PAGE_END);
        return card;

```

* adjust the CardstackSetup inside the "cardManager"-package:
	1. all cards will automatically be imported: `import cards.*`
	1. add the name of your card as public final static string inside the CardstackSetup class: `public final static String NAMEOFYOURCARD = "description"`
	1. instatniate your card inside the addCards-method: `JPanel nameOfYourCard = new NameOfYourCard().create();`
	1. add your card and its name to the cards JPanel: `getCards().add(nameOfYourCard, NAMEOFYOURCARD);`

See "CardstackSetup"-class inside the "cardManager"-package.  

### creating event listener for switching to another card

* in your created card (or menu button) you have to bind an ActionListener to an Element you wish to be responsible for the card switch
* import CardSwitcher and CardstackSetup from "cardManager"-package
* instantiate a new CardSwitcher and give it the CardstackSetup cards and the name of the card you want to go to

```

	backBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
			// this little guy here: 
			new CardSwitcher(CardstackSetup.getCards(), CardstackSetup.ABOUTCARD);
		}
	});


```

### accessing variables across cards

You might come to a point where you want to pass values from one card to another.  
Since of my lack of knowledge in java fundamentals and best-practises I managed this using following procedure:  
* declare and define a public static variable in your card class where the value should be set - e.g. `public static String handOver = null;`
* set the value of the variable **inside your card.create()-method** - e.g. `YourFirstCard.handOver = "I come from another card.";`
* then call the variable from within the card where you want to access the value - e.g. in "YourSecondCard": `System.out.println(YourFirstCard.handOver);`  
I didn't find a method for passing variable values with the ActionListener yet.  
I might add that one day.  


