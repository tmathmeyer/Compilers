package demo1;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class InvalidSyntaxExceptionThrowingError extends BaseErrorListener
{

	@Override
	public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2, int arg3, String arg4, RecognitionException arg5)
	{
		StringBuilder errorMsg = new StringBuilder();
		errorMsg.append("error at position ");
		errorMsg.append(arg2);
		errorMsg.append(";");
		errorMsg.append(arg3);
		errorMsg.append("on symbol ");
		errorMsg.append(arg1);
		errorMsg.append(": ");
		errorMsg.append(arg4);
		
		throw new RuntimeException(errorMsg.toString());
	}

}
