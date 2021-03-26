namespace ejercico8csharp
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }

            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.areaTrabajo = new System.Windows.Forms.PictureBox();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            ((System.ComponentModel.ISupportInitialize) (this.areaTrabajo)).BeginInit();
            this.SuspendLayout();
            // 
            // areaTrabajo
            // 
            this.areaTrabajo.Location = new System.Drawing.Point(-1, 2);
            this.areaTrabajo.Name = "areaTrabajo";
            this.areaTrabajo.Size = new System.Drawing.Size(1005, 462);
            this.areaTrabajo.TabIndex = 0;
            this.areaTrabajo.TabStop = false;
            this.areaTrabajo.Paint += new System.Windows.Forms.PaintEventHandler(this.areaTrabajo_Paint);
            // 
            // timer1
            // 
            this.timer1.Interval = 200;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // frmPrincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1008, 461);
            this.Controls.Add(this.areaTrabajo);
            this.Name = "frmPrincipal";
            this.Text = "Game";
            this.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.Form1_KeyPress);
            this.KeyUp += new System.Windows.Forms.KeyEventHandler(this.Form1_KeyUp);
            ((System.ComponentModel.ISupportInitialize) (this.areaTrabajo)).EndInit();
            this.ResumeLayout(false);
        }

        private System.Windows.Forms.Timer timer1;

        private System.Windows.Forms.PictureBox areaTrabajo;

        #endregion
    }
}