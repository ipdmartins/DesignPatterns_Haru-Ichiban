package view;

import Command.*;
import State.Jogo;
import control.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class Tela extends JFrame implements Observador {

    //TELA DE ABERURA
    private JFrame f;
    private JPanel inicial;
    private Icon haruIcon;
    private JLabel haru2;
    private JButton jbjogadores;
    private Auxiliar aux;
    private JLabel jlredplayer;
    private JLabel jlyellowplayer;

    public Tela() {
        f = new JFrame();
        f.setTitle("HARU ICHIBAN");
        f.setSize(550, 490);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        init();
    }

    public void init() {
        aux = new Auxiliar();
        inicial = new JPanel();
        inicial.setLayout(new BorderLayout());
        f.add(inicial);

        haruIcon = new ImageIcon("imagens/haru2.png");
        haru2 = new JLabel();
        haru2.setIcon(haruIcon);
        jlredplayer = new JLabel("");
        jlyellowplayer = new JLabel("");

        jbjogadores = new JButton();
        jbjogadores.setIcon(haruIcon);
        jbjogadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlredplayer.setText("JOGADOR: " + aux.definirRedPlayer() + "     / ");
                jlyellowplayer.setText("JOGADOR: " + aux.definirYellowPlayer() + "     / ");
                f.setVisible(false);
                f.setEnabled(false);
                String w1 = "Cores definidas. REGRA IMPORTANTE: Toda vez que o senior desejar mover um sapo ele deve clicar no nenufar claro, \n";
                String w2 = "clicar no botao 'salvar nenufar destino', clicar no sapo da cor desejada e finalizar com seu botao 'mover sapo'.";
                JOptionPane.showMessageDialog(null, w1 + w2);
                tela2();
            }
        });
        inicial.add(jbjogadores, BorderLayout.CENTER);
        f.setVisible(true);
    }

    //TELA DE JOGO
    private JTable tabuleiro;
    private JTable redtabuleiro;
    private JTable yellowtabuleiro;
    private JTable pontostabuleiro;

    private JPanel westborderLayout;
    private JPanel eastborderLayout;
    private JPanel centerborderLayout;
    private JPanel botoesPanelRed;
    private JPanel botoesPanelYellow;
    private JPanel botoesPanelTabuleiro;
    private JPanel redLabelTabuleiro;
    private JPanel yellowLabelTabuleiro;
    private JPanel jardineirosPanel;

    private Icon redGardnerIcon;
    private Icon yellowGardnerIcon;

    private JLabel jlyellowstatus;
    private JLabel jlredstatus;
    private JLabel jlredGardner;
    private JLabel jlyellowGardner;

    //BOTÃ•ES EM COMUM
    private JButton jbdefinirstatus;
    private JButton jbventoprimaveraRIGHT;
    private JButton jbventoprimaveraLEFT;
    private JButton jbventoprimaveraUP;
    private JButton jbventoprimaveraDOWN;
    private JButton jbrefazerjogada;
    private JButton jbdesfazerjogada;
    private JButton jbmarcarnenufar;

    //BOTÃ•ES VERMELHO
    private JButton jbpegarflorvermelha;
    private JButton jbmostrarflorVermelha;
    private JButton jbposicionarRed;
    private JButton jbredDarkNenufar;
    private JButton jbmoverSapoRed;
    private JButton jbredSound;

    //BOTÃ•ES AMARELO
    private JButton jbpegarfloramarela;
    private JButton jbmostrarflorAmarela;
    private JButton jbposicionarYellow;
    private JButton jbyellowDarkNenufar;
    private JButton jbmoverSapoYellow;
    private JButton jbyellowSound;

    private Controller controle;
    private Auxiliar loop;
    private CommandInvoker invoker;
    private Jogo jogoSate;

    public void tela2() {
        setTitle("HARU ICHIBAN");
        setSize(1300, 900);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        initComponents();
        pack();
        setVisible(true);
    }

    private void initComponents() {
        //CONTROLER
        controle = controle.getInstance();
        controle.addObservador(this);
        controle.inicializar();
        //COMMAND
        invoker = new CommandInvoker();

        //LABELS
        redGardnerIcon = new ImageIcon(controle.getRedgardner());
        yellowGardnerIcon = new ImageIcon(controle.getYellowgardner());
        jlredstatus = new JLabel("STATUS:          ");
        jlyellowstatus = new JLabel("STATUS:          ");
        jlredGardner = new JLabel();
        jlredGardner.setIcon(redGardnerIcon);
        jlyellowGardner = new JLabel();
        jlyellowGardner.setIcon(yellowGardnerIcon);

        //BUTTONS
        jbpegarflorvermelha = new JButton("Pegar");
        jbpegarfloramarela = new JButton("Pegar");
        jbmostrarflorVermelha = new JButton("Mostrar");
        jbmostrarflorAmarela = new JButton("Mostrar");
        jbdefinirstatus = new JButton("Definir status");
        jbposicionarRed = new JButton("Posicionar flor");
        jbposicionarYellow = new JButton("Posicionar flor");
        jbmarcarnenufar = new JButton("Salva nenufar destino");
        jbmoverSapoRed = new JButton("Mover sapo");
        jbmoverSapoYellow = new JButton("Mover sapo");
        jbredDarkNenufar = new JButton("Set dark");
        jbyellowDarkNenufar = new JButton("Set dark");
        jbventoprimaveraLEFT = new JButton("Vento LEFT");
        jbventoprimaveraDOWN = new JButton("Vento DOWN");
        jbventoprimaveraRIGHT = new JButton("Vento RIGHT");
        jbventoprimaveraUP = new JButton("Vento UP");
        jbdesfazerjogada = new JButton("Desfazer jogada");
        jbrefazerjogada = new JButton("Refazer jogada");
        jbredSound = new JButton("Red coachar");
        jbyellowSound = new JButton("Yellow coachar");

        jogoSate = new Jogo(this);
        montarWestPanel();
        montarCenterPanel();
        montarEastPanel();
        montarTrilhaPanel();
        start();

    }

    private void start() {
        enablePanel("all");

        jbpegarflorvermelha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.add(new PegarFlor(controle, true));
                invoker.execute();
                mudouTabuleiro();
            }
        });

        jbpegarfloramarela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.add(new PegarFlor(controle, false));
                invoker.execute();
                mudouTabuleiro();
            }
        });

        jbmostrarflorVermelha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.add(new MostrarFlor(controle, true));
                invoker.execute();
                mudouTabuleiro();
            }
        });

        jbmostrarflorAmarela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.add(new MostrarFlor(controle, false));
                invoker.execute();
                mudouTabuleiro();
            }
        });

        jbdefinirstatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!controle.isCondmostraramarela() && !controle.isCondmostrarvermelha()) {
                    int num = controle.definirStatus();
                    if (num == 1) {
                        jlredstatus.setText("STATUS: Junior    ");
                        jlyellowstatus.setText("STATUS: Senior    ");
                    } else if (num == 2) {
                        jlredstatus.setText("STATUS: Senior    ");
                        jlyellowstatus.setText("STATUS: Junior    ");
                    } else if (num == 0) {
                        mudouTabuleiro();
                        habilitar("empate");
                    }
                }
            }
        });

        jbredSound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controle.empate(1);
                jlredstatus.setText("STATUS: Senior    ");
                jlyellowstatus.setText("STATUS: Junior    ");
                habilitar("redcoachou");
            }
        });

        jbyellowSound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controle.empate(2);
                jlredstatus.setText("STATUS: Junior    ");
                jlyellowstatus.setText("STATUS: Senior    ");
                habilitar("yellowcoachou");
            }
        });

        jbposicionarRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controle.getRedPlayer().getStatus() != -1) {
                    if (controle.getRedPlayer().getStatus() == 1 || controle.getYellowPlayer().getStatus() == 0
                            || controle.isEmpate()) {
                        invoker.add(new PosicionarFlor(controle, true));
                        invoker.execute();
                        mudouTabuleiro();
                    } else {
                        JOptionPane.showMessageDialog(null, "Jardineiro Junior posiciona no nenufar escuro");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Clicar no botao definir status");
                }
            }
        });

        jbposicionarYellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controle.getYellowPlayer().getStatus() != -1) {
                    if (controle.getYellowPlayer().getStatus() == 1 || controle.getRedPlayer().getStatus() == 0
                            || controle.isEmpate()) {
                        invoker.add(new PosicionarFlor(controle, false));
                        invoker.execute();
                        mudouTabuleiro();
                    } else {
                        JOptionPane.showMessageDialog(null, "Jardineiro Junior posiciona no nenufar escuro");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Clicar no botao definir status");
                }
            }
        });

        jbmarcarnenufar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controle.marcarNenufar();
            }
        });

        jbmoverSapoRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controle.getRedPlayer().getStatus() == 2) {
                    if (controle.getJogadas().getParticipante(1).getJogadas() == 4 || 
                            controle.getJogadas().getParticipante(1).getJogadas() == 2) {
                        invoker.add(new MoverSapo(controle, true));
                        invoker.execute();
                        mudouTabuleiro();
                    } else {
                        JOptionPane.showMessageDialog(null, "Permitido movimentar um sapo por jogada");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Somente jogador Senior autorizado");
                }
            }
        });

        jbmoverSapoYellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controle.getYellowPlayer().getStatus() == 2) {
                    if (controle.getJogadas().getParticipante(1).getJogadas() == 4 ||
                            controle.getJogadas().getParticipante(1).getJogadas() == 2) {
                        invoker.add(new MoverSapo(controle, false));
                        invoker.execute();
                        mudouTabuleiro();
                    } else {
                        JOptionPane.showMessageDialog(null, "Permitido movimentar um sapo por jogada");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Somente jogador Senior autorizado");
                }
            }
        });

        jbventoprimaveraLEFT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.add(new VentoLeft(controle));
                invoker.execute();
                mudouTabuleiro();
            }
        });

        jbventoprimaveraDOWN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.add(new VentoDown(controle));
                invoker.execute();
                mudouTabuleiro();
            }
        });

        jbventoprimaveraRIGHT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.add(new VentoRight(controle));
                invoker.execute();
                mudouTabuleiro();
            }
        });

        jbventoprimaveraUP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.add(new VentoUP(controle));
                invoker.execute();
                mudouTabuleiro();
            }
        });

        jbredDarkNenufar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controle.getRedPlayer().getStatus() == 2) {
                    invoker.add(new SetarDarkNenufar(controle, true));
                    invoker.execute();
                    mudouTabuleiro();
                } else {
                    JOptionPane.showMessageDialog(null, "Somente jogador Senior autorizado");
                }
            }
        });

        jbyellowDarkNenufar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controle.getYellowPlayer().getStatus() == 2) {
                    invoker.add(new SetarDarkNenufar(controle, false));
                    invoker.execute();
                    mudouTabuleiro();
                } else {
                    JOptionPane.showMessageDialog(null, "Somente jogador Senior autorizado");
                }
            }
        });

        jbdesfazerjogada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.undo();
                mudouTabuleiro();
            }
        });

        jbrefazerjogada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoker.redo();
                mudouTabuleiro();
            }
        });

        jogoSate.avancarEtapa();
    }

    private void enablePanel(String s) {
        if (s.equals("none")) {
            redtabuleiro.setEnabled(false);
            tabuleiro.setEnabled(false);
            yellowtabuleiro.setEnabled(false);
        } else if (s.equals("all")) {
            redtabuleiro.setEnabled(true);
            tabuleiro.setEnabled(true);
            yellowtabuleiro.setEnabled(true);
        } else if (s.equals("center")) {
            redtabuleiro.setEnabled(false);
            tabuleiro.setEnabled(true);
            yellowtabuleiro.setEnabled(false);
        } else if (s.equals("east")) {
            redtabuleiro.setEnabled(false);
            tabuleiro.setEnabled(false);
            yellowtabuleiro.setEnabled(true);
        } else if (s.equals("wc")) {
            redtabuleiro.setEnabled(true);
            tabuleiro.setEnabled(true);
        } else if (s.equals("we")) {
            tabuleiro.setEnabled(true);
            yellowtabuleiro.setEnabled(true);
        } else if (s.equals("both")) {
            redtabuleiro.setEnabled(true);
            yellowtabuleiro.setEnabled(true);
        }
    }

    private void montarWestPanel() {
        westborderLayout = new JPanel();
        westborderLayout.setLayout(new BorderLayout());
        redLabelTabuleiro = new JPanel();
        redLabelTabuleiro.setLayout(new FlowLayout());
        redtabuleiro = new JTable();
        redtabuleiro.setModel(new redTable());
        for (int x = 0; x < redtabuleiro.getColumnModel().getColumnCount(); x++) {
            redtabuleiro.getColumnModel().getColumn(x).setWidth(100);
            redtabuleiro.getColumnModel().getColumn(x).setMinWidth(100);
            redtabuleiro.getColumnModel().getColumn(x).setMaxWidth(100);
        }
        redtabuleiro.setRowHeight(100);
        redtabuleiro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        redtabuleiro.setShowGrid(true);
        redtabuleiro.setIntercellSpacing(new Dimension(1, 1));
        redtabuleiro.setDefaultRenderer(Object.class, new tabuleiroRenderer());

        redtabuleiro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    panelBorderSetter("west");
                    controle.pegarIndexRed(redtabuleiro.getSelectedRow(), redtabuleiro.getSelectedColumn());
                }
            }
        });

        westborderLayout.add(redtabuleiro, BorderLayout.NORTH);

        redLabelTabuleiro.add(jlredplayer);
        redLabelTabuleiro.add(jlredstatus);
        westborderLayout.add(redLabelTabuleiro, BorderLayout.SOUTH);
        montarPainelBotoesWest();
        add(westborderLayout, BorderLayout.WEST);
    }

    private void montarCenterPanel() {
        centerborderLayout = new JPanel();
        centerborderLayout.setLayout(new BorderLayout());
        tabuleiro = new JTable();
        tabuleiro.setModel(new tabuleiroTable());
        for (int x = 0; x < tabuleiro.getColumnModel().getColumnCount(); x++) {
            tabuleiro.getColumnModel().getColumn(x).setWidth(100);
            tabuleiro.getColumnModel().getColumn(x).setMinWidth(100);
            tabuleiro.getColumnModel().getColumn(x).setMaxWidth(100);
        }
        tabuleiro.setRowHeight(100);
        tabuleiro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabuleiro.setShowGrid(false);
        tabuleiro.setIntercellSpacing(new Dimension(1, 1));
        tabuleiro.setDefaultRenderer(Object.class, new tabuleiroRenderer());

        tabuleiro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    panelBorderSetter("center");
                    controle.pegarIndexTabuleiro(tabuleiro.getSelectedRow(), tabuleiro.getSelectedColumn());
                }
            }
        });
        centerborderLayout.add(tabuleiro, BorderLayout.NORTH);
        montarBotoesCenter();
        add(centerborderLayout, BorderLayout.CENTER);
    }

    private void montarTrilhaPanel() {
        jardineirosPanel = new JPanel();
        jardineirosPanel.setLayout(new FlowLayout());

        pontostabuleiro = new JTable();
        pontostabuleiro.setModel(new pontosTable());
        for (int x = 0; x < pontostabuleiro.getColumnModel().getColumnCount(); x++) {
            pontostabuleiro.getColumnModel().getColumn(x).setWidth(55);
            pontostabuleiro.getColumnModel().getColumn(x).setMinWidth(55);
            pontostabuleiro.getColumnModel().getColumn(x).setMaxWidth(55);
        }
        pontostabuleiro.setRowHeight(55);
        pontostabuleiro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pontostabuleiro.setShowGrid(false);
        pontostabuleiro.setIntercellSpacing(new Dimension(1, 1));
        pontostabuleiro.setDefaultRenderer(Object.class, new tabuleiroRenderer());

        jardineirosPanel.add(jlredGardner);
        jardineirosPanel.add(pontostabuleiro);
        jardineirosPanel.add(jlyellowGardner);
        add(jardineirosPanel, BorderLayout.SOUTH);
    }

    private void montarEastPanel() {
        eastborderLayout = new JPanel();
        eastborderLayout.setLayout(new BorderLayout());
        yellowLabelTabuleiro = new JPanel();
        yellowLabelTabuleiro.setLayout(new FlowLayout());
        yellowtabuleiro = new JTable();
        yellowtabuleiro.setModel(new yellowTable());

        for (int x = 0; x < yellowtabuleiro.getColumnModel().getColumnCount(); x++) {
            yellowtabuleiro.getColumnModel().getColumn(x).setWidth(100);
            yellowtabuleiro.getColumnModel().getColumn(x).setMinWidth(100);
            yellowtabuleiro.getColumnModel().getColumn(x).setMaxWidth(100);
        }
        yellowtabuleiro.setRowHeight(100);
        yellowtabuleiro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        yellowtabuleiro.setShowGrid(false);
        yellowtabuleiro.setIntercellSpacing(new Dimension(1, 1));
        yellowtabuleiro.setDefaultRenderer(Object.class, new tabuleiroRenderer());

        yellowtabuleiro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    panelBorderSetter("east");
                    controle.pegarIndexYellow(yellowtabuleiro.getSelectedRow(), yellowtabuleiro.getSelectedColumn());
                }
            }
        });
        eastborderLayout.add(yellowtabuleiro, BorderLayout.NORTH);

        yellowLabelTabuleiro.add(jlyellowplayer);
        yellowLabelTabuleiro.add(jlyellowstatus);
        eastborderLayout.add(yellowLabelTabuleiro, BorderLayout.SOUTH);
        montarPainelBotoesEast();
        add(eastborderLayout, BorderLayout.EAST);
    }

    private void panelBorderSetter(String s) {
        if (s.equals("west")) {
            redtabuleiro.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 4));
            tabuleiro.setBorder(null);
            yellowtabuleiro.setBorder(null);
        } else if (s.equals("center")) {
            tabuleiro.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 4));
            redtabuleiro.setBorder(null);
            yellowtabuleiro.setBorder(null);
        } else if (s.equals("east")) {
            yellowtabuleiro.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 4));
            redtabuleiro.setBorder(null);
            tabuleiro.setBorder(null);
        }
    }

    private void montarPainelBotoesWest() {
        botoesPanelRed = new JPanel();
        botoesPanelRed.setLayout(new GridLayout(3, 3));
        botoesPanelRed.add(jbpegarflorvermelha);
        botoesPanelRed.add(jbmostrarflorVermelha);
        botoesPanelRed.add(jbposicionarRed);
        botoesPanelRed.add(jbmoverSapoRed);
        botoesPanelRed.add(jbredDarkNenufar);
        botoesPanelRed.add(jbredSound);
        westborderLayout.add(botoesPanelRed, BorderLayout.CENTER);
    }

    private void montarPainelBotoesEast() {
        botoesPanelYellow = new JPanel();
        botoesPanelYellow.setLayout(new GridLayout(3, 3));
        botoesPanelYellow.add(jbpegarfloramarela);
        botoesPanelYellow.add(jbmostrarflorAmarela);
        botoesPanelYellow.add(jbposicionarYellow);
        botoesPanelYellow.add(jbmoverSapoYellow);
        botoesPanelYellow.add(jbyellowDarkNenufar);
        botoesPanelYellow.add(jbyellowSound);
        eastborderLayout.add(botoesPanelYellow, BorderLayout.CENTER);
    }

    private void montarBotoesCenter() {
        botoesPanelTabuleiro = new JPanel();
        botoesPanelTabuleiro.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.ipady = 9;
        c.ipadx = 43;
        c.gridx = 0;
        c.gridy = 0;
        botoesPanelTabuleiro.add(jbdefinirstatus, c);

        c.fill = GridBagConstraints.BOTH;
        c.ipady = 9;
        c.ipadx = 43;
        c.gridx = 1;
        c.gridy = 0;
        botoesPanelTabuleiro.add(jbventoprimaveraLEFT, c);

        c.fill = GridBagConstraints.BOTH;
        c.ipady = 9;
        c.ipadx = 43;
        c.gridx = 2;
        c.gridy = 0;
        botoesPanelTabuleiro.add(jbventoprimaveraUP, c);

        c.fill = GridBagConstraints.BOTH;
        c.ipady = 9;
        c.ipadx = 43;
        c.gridx = 0;
        c.gridy = 1;
        botoesPanelTabuleiro.add(jbmarcarnenufar, c);

        c.fill = GridBagConstraints.BOTH;
        c.ipady = 9;
        c.ipadx = 43;
        c.gridx = 1;
        c.gridy = 1;
        botoesPanelTabuleiro.add(jbventoprimaveraRIGHT, c);

        c.fill = GridBagConstraints.BOTH;
        c.ipady = 9;
        c.ipadx = 43;
        c.gridx = 2;
        c.gridy = 1;
        botoesPanelTabuleiro.add(jbventoprimaveraDOWN, c);

        centerborderLayout.add(botoesPanelTabuleiro, BorderLayout.SOUTH);
    }

    class pontosTable extends AbstractTableModel {

        @Override
        public int getColumnCount() {
            return 9;
        }

        @Override
        public int getRowCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int row, int col) {
            try {
                return controle.getPecaPontosTabuleiro(row, col);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
    }

    class tabuleiroTable extends AbstractTableModel {

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public int getRowCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int row, int col) {
            try {
                return controle.getPecaTabuleiro(row, col);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
    }

    class redTable extends AbstractTableModel {

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public int getRowCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int row, int col) {
            try {
                return controle.getPecaRedTabuleiro(row, col);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
    }

    class yellowTable extends AbstractTableModel {

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public int getRowCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int row, int col) {
            try {
                return controle.getPecaYellowTabuleiro(row, col);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
    }

    class tabuleiroRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            setIcon(new ImageIcon(value.toString()));
            return this;
        }
    }

    @Override
    public void habilitar(String s) {
        jbpegarflorvermelha.setEnabled(false);
        jbpegarfloramarela.setEnabled(false);
        jbmostrarflorVermelha.setEnabled(false);
        jbmostrarflorAmarela.setEnabled(false);
        jbposicionarRed.setEnabled(false);
        jbposicionarYellow.setEnabled(false);
        jbmoverSapoRed.setEnabled(false);
        jbmoverSapoYellow.setEnabled(false);
        jbyellowDarkNenufar.setEnabled(false);
        jbredDarkNenufar.setEnabled(false);
        jbredSound.setEnabled(false);
        jbyellowSound.setEnabled(false);
        jbdefinirstatus.setEnabled(false);
        jbmarcarnenufar.setEnabled(false);
        jbventoprimaveraDOWN.setEnabled(false);
        jbventoprimaveraLEFT.setEnabled(false);
        jbventoprimaveraRIGHT.setEnabled(false);
        jbventoprimaveraUP.setEnabled(false);

        switch (s) {
            case "pegar":
                JOptionPane.showMessageDialog(null, "Jodagores devem selecionar ou repor as 3 flores iniciais com o clique e botao pegar");
                jbpegarflorvermelha.setEnabled(true);
                jbpegarfloramarela.setEnabled(true);
                break;
            case "mostrar":
                JOptionPane.showMessageDialog(null, "Jogadores devem clicar na flor escolhida, em seguida botao mostrar");
                jbmostrarflorVermelha.setEnabled(true);
                jbmostrarflorAmarela.setEnabled(true);
                break;
            case "status":
                JOptionPane.showMessageDialog(null, "Clicar no botao definir Status");
                jbdefinirstatus.setEnabled(true);
                break;
            case "empate":
                JOptionPane.showMessageDialog(null, "Jogadores empataram no status");
                jbredSound.setEnabled(true);
                jbyellowSound.setEnabled(true);
                break;
            case "redcoachou":
                JOptionPane.showMessageDialog(null, "Vermelho coachou primeiro, você deve reposicionar os sapos em nenufares claros, somente depois de move-los finalize com botao posicionar");
                jbyellowSound.setEnabled(false);
                jbmarcarnenufar.setEnabled(true);
                jbmoverSapoRed.setEnabled(true);
                jbposicionarRed.setEnabled(true);
                break;
            case "yellowcoachou":
                JOptionPane.showMessageDialog(null, "Amarelo coachou primeiro, você deve reposicionar os sapos em nenufares claros, somente depois de move-los finalize com botao posicionar");
                jbredSound.setEnabled(false);
                jbmarcarnenufar.setEnabled(true);
                jbmoverSapoYellow.setEnabled(true);
                jbposicionarYellow.setEnabled(true);
                break;
            case "posisionarR":
                JOptionPane.showMessageDialog(null, "Vermelho junior, clique no nenufar escuro em seguida botao posicionar");
                jbposicionarRed.setEnabled(true);
                break;
            case "posisionarY":
                JOptionPane.showMessageDialog(null, "Amarelo junior, clique no nenufar escuro em seguida botao posicionar");
                jbposicionarYellow.setEnabled(true);
                break;
            case "posisionarYS":
                JOptionPane.showMessageDialog(null, "Amarelo senior, clique em algum nenufar claro em seguida botao posicionar");
                jbmarcarnenufar.setEnabled(true);
                jbposicionarYellow.setEnabled(true);
                jbmoverSapoYellow.setEnabled(true);
                break;
            case "posisionarRS":
                JOptionPane.showMessageDialog(null, "Vermelho senior, clique em algum nenufar claro em seguida botao posicionar");
                jbmarcarnenufar.setEnabled(true);
                jbposicionarRed.setEnabled(true);
                jbmoverSapoRed.setEnabled(true);
                break;
            case "vento":
                JOptionPane.showMessageDialog(null, "Junior deve chamar o vento da primavera");
                jbventoprimaveraDOWN.setEnabled(true);
                jbventoprimaveraLEFT.setEnabled(true);
                jbventoprimaveraRIGHT.setEnabled(true);
                jbventoprimaveraUP.setEnabled(true);
                break;
            case "darkYellow":
                JOptionPane.showMessageDialog(null, "Amarelo senior deve clicar em nenufar claro, depois em botao Set Dark");
                jbyellowDarkNenufar.setEnabled(true);
                jbmarcarnenufar.setEnabled(true);
                jbmoverSapoYellow.setEnabled(true);
                break;
            case "darkRed":
                JOptionPane.showMessageDialog(null, "Vermelho senior deve clicar em nenufar claro, depois em botao Set Dark");
                jbredDarkNenufar.setEnabled(true);
                jbmarcarnenufar.setEnabled(true);
                jbmoverSapoRed.setEnabled(true);
                break;
        }
    }

    @Override
    public void mudouTabuleiro() {
        tabuleiro.repaint();
        yellowtabuleiro.repaint();
        redtabuleiro.repaint();
        pontostabuleiro.repaint();
    }

    @Override
    public void fimJogo() {
        mudouTabuleiro();
        habilitar("");
        if (controle.getRedPlayer().getPontos() > controle.getYellowPlayer().getPontos()) {
            JOptionPane.showMessageDialog(null, "Fim de jogo, Jogador vermelho jardineiro imperial");
        } else {
            JOptionPane.showMessageDialog(null, "Fim de jogo, jogador amarelo jardineiro imperial");
        }
        enablePanel("none");
    }

    @Override
    public void proximaEtapa() {
        jogoSate.avancarEtapa();
    }

    @Override
    public void novaRodada() {
        jogoSate = new Jogo(this);
        jogoSate.avancarEtapa();
    }
}
