package exercicegeometrieexception.ctrl;

import exercicegeometrieexception.ihm.IIhmCtrl;
import exercicegeometrieexception.wrk.IWrkCtrl;

public class Ctrl implements ICtrlIhm {

    private IIhmCtrl refIhm;
    private IWrkCtrl refWorker;

    public void demarrer() {
        refIhm.demarrer();
    }

    @Override
    public void selectCalcRadius(String value) {
        try {
            double valueDouble = Double.parseDouble(value);
            refIhm.afficheResultatCircle(String.valueOf(refWorker.calcRadiusCircleFromArea(valueDouble)));
        } catch (NumberFormatException e) {
            refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'aire du cercle ( " + value + " invalide )");
        }
    }

    @Override
    public void selectCalcLargeur(String valueArea, String valueLongueur) {
        try {
            double valueAreaDouble = Double.parseDouble(valueArea);
            double valueLongueurDouble = Double.parseDouble(valueLongueur);
            refIhm.afficheResultatRectangle(
                    String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));
        } catch (NumberFormatException e) {
            if (e.getMessage().contains(valueArea)) {
                refIhm.afficheMessage(
                        "Veuillez entrer une valeur valide pour l'aire du rectangle ( " + valueArea + " invalide )");
            } else if (e.getMessage().contains(valueLongueur)) {
                refIhm.afficheMessage("Veuillez entrer une valeur valide pour la longeur du rectangle ( "
                        + valueLongueur + " invalide )");
            }
        }
    }

    public void setRefIhm(IIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWorker(IWrkCtrl refWorker) {
        this.refWorker = refWorker;
    }

}
