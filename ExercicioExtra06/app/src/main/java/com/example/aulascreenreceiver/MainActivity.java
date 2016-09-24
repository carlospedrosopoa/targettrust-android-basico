package com.example.aulascreenreceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

/*
 * Como lidar com o Intent.ACTION_SCREEN_OFF e o Intent.ACTION_SCREEN_ON, 
 * ser� bacana se voc� estiver fazendo uma aplica��o que pode precisar 
 * salvar o estado ou responder a tela do usu�rio de ir dormir / acordar, etc.
 * Em primeiro lugar, ao contr�rio de outros broadcasted intents 
 * (inten��es transmitidos), por Intent.ACTION_SCREEN_OFF e 
 * Intent.ACTION_SCREEN_ON voc� n�o pode declar�-las no seu manifesto Android! 
 * Eu n�o sei exatamente o porqu�, mas eles devem ser registrados em um 
 * IntentFilter no seu c�digo Java. E assim, para este exemplo, vamos ter um 
 * receptor chamado ScreenReceiver, e eu vou lev�-lo atrav�s das diferen�as 
 * entre a sua aplica��o em um servi�o versus atividade.
 * 
 * origem: http://thinkandroid.wordpress.com/2010/01/24/handling-screen-off-and-screen-on-intents/
 * 
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//INICIALIZAR RECEPTOR
		IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        BroadcastReceiver mReceiver = new ScreenReceiver();
        registerReceiver(mReceiver, filter);
	}
	@Override
    protected void onPause() {
        // Quando a tela est� prestes a ser desligada
        if (ScreenReceiver.wasScreenOn) {
            // Este � o caso quando OnPause () � chamado pelo sistema devido a uma mudan�a de estado TELA
            System.out.println("SCREEN TURNED OFF");
        } else {
            // Isto �, quando OnPause () � chamado quando o estado de tela n�o foi alterado.
        }
        super.onPause();
    }
 
    @Override
    protected void onResume() {
        // Somente quando a tela se acende
        if (!ScreenReceiver.wasScreenOn) {
            // Isto �, quando onResume () � chamado devido a uma mudan�a ESTADO DA TELA
            System.out.println("SCREEN TURNED ON");
        } else {
            // Isto �, quando onResume () � chamado quando o estado de tela n�o foi alterado
        }
        super.onResume();
    }
}
