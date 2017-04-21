package com.example.heyang.lungcheck.util;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

public class DialogUtil
{
	// Design a notice box
	public static void showDialog(final Context ctx
			, String msg , boolean goHome)
	{
		// Create an object of AlertDialog.Builder
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx)
				.setMessage(msg).setCancelable(false);
		if(goHome)
		{
			//builder.setPositiveButton("OK", new OnClickListener()
			//{
			//	@Override
			//	public void onClick(DialogInterface dialog, int which)
			//	{
			//		Intent i = new Intent(ctx , AuctionClientActivity.class);
			//		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			//		ctx.startActivity(i);
			//	}
			//});
		}
		else
		{
			builder.setPositiveButton("OK", null);
		}
		builder.create().show();
	}
	// Design a showDialog box
	public static void showDialog(Context ctx , View view)
	{
		new AlertDialog.Builder(ctx)
				.setView(view).setCancelable(false)
				.setPositiveButton("OK", null)
				.create()
				.show();
	}
}

