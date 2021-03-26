using System;
using System.Drawing;
using System.Windows.Forms;

namespace ejercico8csharp
{
    public partial class Form1 : Form
    {
        private Image player = null;
        private int x, y;
        private int fx, fy;
        private int playerMov = 0;
        private double velociddad = .1;
        private int tiempo = 200;
        private bool tipo = false;
        public Form1()
        {
            InitializeComponent();
            player = Image.FromFile("Recursos\\SpriteCat.png");
            x = y = 0;
            fx = fy = 0;
            tipo = false;
            timer1.Enabled = true;
            timer1.Start();
        }

        private void areaTrabajo_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;
            g.DrawImage(player, 
                new Rectangle(x,y,80,90), 
                fx + playerMov * 80, fy,80,90, GraphicsUnit.Pixel);
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            playerMov++;
            if (playerMov >= 3) playerMov = 0;
            if (tipo) fy = 200;
            else fy = 0;
            Console.WriteLine("Move " + playerMov);
            collisionCheck();
            areaTrabajo.Invalidate();
        }

        private void collisionCheck()
        {
            //Si llega al limite derecho
            if (x + 90 >= areaTrabajo.Width)
            {
                x = areaTrabajo.Width - 90;
            }

            if (x <= 0)
            {
                x = 0;
            }
        }

        private void Form1_KeyPress(object sender, KeyPressEventArgs e)
        {
            Console.WriteLine(e.KeyChar.ToString());
            int distancia = (int) velociddad * tiempo;
            if (e.KeyChar == 65)
            {
                x--;
                tipo = true;
            }

            if (e.KeyChar == 68)
            {
                x++;
                tipo = true;
            }
        }

        private void Form1_KeyUp(object sender, KeyEventArgs e)
        {
            Console.WriteLine("Loberando ");
            tipo = false;
        }
    }
}