using System;
using System.Windows;

namespace RockPaperScissors
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        String UserSelection = "";
        readonly String Rock = "Rock";
        readonly String Paper = "Paper";
        readonly String Scissors = "Scissors";
        String ComputerSelection = "";
        readonly String Tie = "tie";
        readonly String Computer = "Computer";
        readonly String Player = "Player";
        readonly String DefaultMessage = "Select Continue to try to beat the Computer!";
        readonly String WinMessagePlayer = "You Won!";
        readonly String WinMessageComputer = "You Lose!";
        readonly String TieMessage = "It is a tie!";
        bool DidUserSelect = true;

        public MainWindow()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (DetermineUserSelection())
            {
                DetermineComputerSelection();
                CreateWinMessage(DetermineWhoWon());
            }
        }

        private bool DetermineUserSelection()
        {
            DidUserSelect = true;
            if (RockRadioButton.IsChecked == true)
            {
                UserSelection = Rock;
            }
            else if (PaperRadioButton.IsChecked == true)
            {
                UserSelection = Paper;
            }
            else if (ScissorRadioButton.IsChecked == true)
            {
                UserSelection = Scissors;
            }
            else {
                MessageBox.Text = "Choose one of the above before pressing the Conitnue Button";
                DidUserSelect = false;
            }
            return DidUserSelect;
        }

        private String DetermineWhoWon()
        {
            if (UserSelection.Equals(ComputerSelection))
            {
                return Tie;
            }
            else if (UserSelection == Rock)
            {
                if(ComputerSelection == Paper)
                {
                    return Computer;
                }
                else
                {
                    return Player;
                }
            }
            else if (UserSelection == Paper)
            {
                if (ComputerSelection == Scissors)
                {
                    return Computer;
                }
                else
                {
                    return Player;
                }
            }
            else
            {
                if (UserSelection == Scissors)
                {
                    if (ComputerSelection == Rock)
                    {
                        return Computer;
                    }
                    else
                    {
                        return Player;
                    }
                }
            }
            return Tie; // This will prevent errors from stopping the game
        }

        private void DetermineComputerSelection()
        {
            Random randumNumberGenerator = new Random();
            switch (randumNumberGenerator.Next(1, 3))
            {
                case 1:
                    ComputerSelection = Rock;
                    break;
                case 2:
                    ComputerSelection = Paper;
                    break;
                case 3:
                    ComputerSelection = Scissors;
                    break;
            }
        }

        private void CreateWinMessage(String winner)
        {
            if (winner.Equals(Player))
            {
                MessageBox.Text = WinMessagePlayer + "\nYou selected " + UserSelection + " and the Computer chose " + ComputerSelection;
            }
            else if (winner.Equals(Computer))
            {
                MessageBox.Text = WinMessageComputer + "\nYou selected " + UserSelection + " and the Computer chose " + ComputerSelection;
            }
            else
            {
                MessageBox.Text = TieMessage + "\nYou selected " + UserSelection + " and the Computer chose " + ComputerSelection;
            }
        }

        private void RadioButton_Clicked(object sender, RoutedEventArgs e)
        {
            MessageBox.Text = DefaultMessage;
        }
    }
}
