package snake;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class SnakeApp {

	protected Shell shell;
	private Canvas canvas;
	
	private Body snk;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SnakeApp window = new SnakeApp();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	private void draw(){
		GC gc = new GC(canvas);
		gc.fillRectangle(0, 0, canvas.getBounds().width, canvas.getBounds().height);
		for(int i = 0; i < snk.length(); i++){
			gc.drawOval(snk.getItemCoordinates(i)[0], snk.getItemCoordinates(i)[1], Body.uni, Body.uni);
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.keyCode){
				case 16777217:
					snk.move('u');
					break;
				case 16777218:
					snk.move('d');
					break;
				case 16777219:
					snk.move('l');
					break;
				case 16777220:
					snk.move('r');
					break;
				}
				draw();
			}
		});
		shell.setSize(650, 450);
		shell.setText("Games");
		
		canvas = new Canvas(shell, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				Body.uni = 10;
				Punto.xMax = canvas.getBounds().width;
				Punto.yMax = canvas.getBounds().height;
				snk = new Body();
				GC gc = new GC(canvas);
				for(int i = 0; i < snk.length(); i++){
					gc.drawOval(snk.getItemCoordinates(i)[0], snk.getItemCoordinates(i)[1], Body.uni, Body.uni);
				}
			}
		});
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		canvas.setBounds(0, 0, 634, 411);

	}
}
