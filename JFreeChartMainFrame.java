public class JFreeChartMainFrame extends JFrame {
    private JPanel contentPane;
    private JTextField textFieldFrom;
    private JTextField textFieldTo;
    private JTextField textFieldStep;
    private JTextField textFieldFunc;
    private XYSeries series;
    private XYSeries der;
    private double start;
    private double stop;
    private double step;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JFreeChartMainFrame frame = new JFreeChartMainFrame();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public JFreeChartMainFrame() {
        setResizable(true);
        setTitle("GUIInterpolation");
        setBounds(100, 100, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 20, 5, 20));
        contentPane.setLayout(new BorderLayout(100, 5));
        setContentPane(contentPane);
        JPanel panelButtons = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
        flowLayout.setHgap(5);
        contentPane.add(panelButtons, BorderLayout.NORTH);
        JButton btnNewButtonPlot = new JButton("Plot");
        btnNewButtonPlot.addActionListener(e -> {
            start = Double.parseDouble(textFieldFrom.getText());
            stop = Double.parseDouble(textFieldTo.getText());
            step = Double.parseDouble(textFieldStep.getText());
            series.clear();
            der.clear();
            Parser parser = new Parser(Parser.STANDARD_FUNCTIONS);
            Variable var = new Variable("x");
            Variable par = new Variable("a");
            String funStr = String.valueOf(textFieldFunc.getText());
            parser.add(var);
            parser.add(par);
            ExpressionProgram funs = parser.parse(funStr);
            Expression ders = funs.derivative(var);
            double a = 0.5;
            par.setVal(a);
            for (double x = start; x < stop; x += step) {
                var.setVal(x);
                series.add(x, funs.getVal());
                der.add(x, ders.getVal());
            }
        });
        panelButtons.add(btnNewButtonPlot);
        JButton btnNewButtonExit = new JButton("Exit");
        btnNewButtonExit.addActionListener(e -> System.exit(0));
        panelButtons.add(btnNewButtonExit);
        JPanel panelData = new JPanel();
        contentPane.setBounds(5, 5, 200, 200);
        contentPane.add(panelData, BorderLayout.SOUTH);
        JLabel lblNewLabelfunc = new JLabel("f(x)= ");
        panelData.add(lblNewLabelfunc);
        textFieldFunc = new JTextField();
        textFieldFunc.setText("sin(x)/x");
        panelData.add(textFieldFunc);
        textFieldFunc.setColumns(15);
        JLabel lblNewLabelStart = new JLabel("From:");
        panelData.add(lblNewLabelStart);
        textFieldFrom = new JTextField();
        textFieldFrom.setText("-6");
        panelData.add(textFieldFrom);
        textFieldFrom.setColumns(5);
        JLabel lblNewLabelTo = new JLabel("To:");
        panelData.add(lblNewLabelTo);
        textFieldTo = new JTextField();
        textFieldTo.setText("6");
        panelData.add(textFieldTo);
        textFieldTo.setColumns(5);
        JLabel lblNewLabelStep = new JLabel("Step:");
        panelData.add(lblNewLabelStep);
        textFieldStep = new JTextField();
        textFieldStep.setText("0.01");
        panelData.add(textFieldStep);
        textFieldStep.setColumns(5);
        JFreeChart chart = createChart();
        ChartPanel chartPanel = new ChartPanel(chart);
        contentPane.add(chartPanel, BorderLayout.CENTER);
    }
    private JFreeChart createChart() {
        series = new XYSeries("Function");
        der = new XYSeries("Derivative");
        Parser parser = new Parser(Parser.STANDARD_FUNCTIONS);
        Variable var = new Variable("x");
        Variable par = new Variable("a");
        String funStr = String.valueOf(textFieldFunc.getText());
        parser.add(var);
        parser.add(par);
        ExpressionProgram funs = parser.parse(funStr);
        Expression ders = funs.derivative(var);
        double a = 0.5;
        par.setVal(a); // значение а
        for (double x = start; x < stop; x += step) {
            var.setVal(x);
            series.add(x, funs.getVal());
            der.add(x, ders.getVal());
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        dataset.addSeries(der);
        JFreeChart chart = ChartFactory.createXYLineChart("", "X", "Y", dataset);
        chart.setBackgroundPaint(Color.lightGray);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setOutlinePaint(Color.GREEN);
        plot.setBackgroundPaint(ChartColor.BLACK);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.WHITE);
        return chart;
    }
}
