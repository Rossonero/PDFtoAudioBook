package ca.openlanguage.pdftoaudiobook.ui;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import ca.openlanguage.pdftoaudiobook.R;

public class PDFtoAudioBookHomeActivity extends Activity implements TextToSpeech.OnInitListener {
	private static final String TAG = "PDFtoAudioBookHomeActivity";
	/** Talk to the user */
    private TextToSpeech mTts;

    
    
  //implement on Init for the text to speech
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
			// Set preferred language to US english.
			// Note that a language may not be available, and the result will
			// indicate this.
			int result = mTts.setLanguage(Locale.US);
			// Try this someday for some interesting results.
			// int result mTts.setLanguage(Locale.FRANCE);
			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				// Language data is missing or the language is not supported.
				Log.e(TAG, "Language is not available.");
			} else {

				// mSpeakButton.setEnabled(true);
				// mPauseButton.setEnabled(true);
				// Greet the user.
				// sayHello();
			}
		} else {
			// Initialization failed.
			Log.e(TAG, "Could not initialize TextToSpeech.");
		}
	}
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        

        mTts = new TextToSpeech(this, this);
//        mTts.speak("This is a sample Home following UI best practices.",
//    	        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
//    	        null);

    }
    
    public void onStarredClick(View v){
    	startActivity(new Intent(this, ChunksActivity.class));
    }
    public void onAudioBookClick(View v){
    	startActivity(new Intent(this, DocumentsActivity.class));
    }
    public void onListenClick(View v){
    	startActivity(new Intent(this, ChunksActivity.class));
    }
    /** Handle "mind map" action. */
    public void onMindMapClick(View v) {
    	startActivity(new Intent(this, DocumentsActivity.class));
//    	mTts.speak("This would open the relevant mind map.",
//    	        TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
//    	        null);
    }
}