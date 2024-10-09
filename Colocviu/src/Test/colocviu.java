package Test;

import java.util.ArrayList;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataFloat;
import DataObjects.DataSubPetriNet;
import DataObjects.DataTransfer;
import DataOnly.SubPetri;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;
public class colocviu {
    public static void main(String args[]){

        // main
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Main Petri";
        pn.NetworkPort = 1080;

        // sub Petri Net
        PetriNet spn = new PetriNet();
        spn.PetriNetName = "SubPetri";

        DataFloat subConstantValue1 = new DataFloat();
        subConstantValue1.SetName("subConstantValue1");
        subConstantValue1.SetValue(0.01f);
        spn.ConstantPlaceList.add(subConstantValue1);

        DataFloat p4 = new DataFloat();
        p4.SetName("p4");
        spn.PlaceList.add(p4);

        DataFloat p5 = new DataFloat();
        p5.SetName("p5");
        spn.PlaceList.add(p5);

        DataFloat p6 = new DataFloat();
        p6.SetName("p6");
        spn.PlaceList.add(p6);

        DataTransfer p8 = new DataTransfer();
        p8.SetName("p8");
        p8.Value = new TransferOperation("localhost", "1080", "p9");
        spn.PlaceList.add(p8);

        PetriTransition t4 = new PetriTransition(spn);
        t4.TransitionName = "t4";
        t4.InputPlaceName.add("p4");

        Condition T4Ct1 = new Condition(t4, "p4", TransitionCondition.NotNull);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;

        ArrayList<String> lstInput = new ArrayList<String>();
        lstInput.add("p4");
        lstInput.add("subConstantValue1");
        grdT4.Activations.add(new Activation(t4, lstInput, TransitionOperation.Prod, "p5"));

        t4.GuardMappingList.add(grdT4);
        t4.Delay = 0;
        spn.Transitions.add(t4);

        PetriTransition t5 = new PetriTransition(spn);
        t5.TransitionName = "t5";
        t5.InputPlaceName.add("p5");

        Condition T5Ct1 = new Condition(t5, "p5", TransitionCondition.NotNull);
        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;
        grdT5.Activations.add(new Activation(t5,"p5", TransitionOperation.SendOverNetwork, "p8"));
        grdT5.Activations.add(new Activation(t5,"p5", TransitionOperation.Move, "p8"));
        grdT5.Activations.add(new Activation(t5,"p5", TransitionOperation.Move, "p6"));


        t5.GuardMappingList.add(grdT5);
        t5.Delay = 0;
        spn.Transitions.add(t5);

        PetriTransition t6 = new PetriTransition(spn);
        t6.TransitionName = "t6";
        t6.InputPlaceName.add("p6");

        Condition T6Ct1 = new Condition(t6, "p6", TransitionCondition.NotNull);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;
        grdT6.Activations.add(new Activation(t6,"", TransitionOperation.StopPetriNet, ""));

        t6.GuardMappingList.add(grdT6);
        t6.Delay = 0;
        spn.Transitions.add(t6);

        spn.Delay = 3000;

        //--------------
        DataSubPetriNet subPetriNet = new DataSubPetriNet();
        subPetriNet.SetName("SubPetri");
        SubPetri sptr = new SubPetri(spn);
        subPetriNet.SetValue(sptr);
        pn.ConstantPlaceList.add(subPetriNet);

        DataFloat p0 = new DataFloat();
        p0.SetName("p0");
        p0.SetValue(1.0f);
        pn.PlaceList.add(p0);

        DataFloat p7 = new DataFloat();
        p7.SetName("p7");
        p7.SetValue(1.0f);
        pn.PlaceList.add(p7);

        DataSubPetriNet p1 = new DataSubPetriNet();
        p1.SetName("p1");
        pn.PlaceList.add(p1);

        DataFloat p2 = new DataFloat();
        p2.SetName("p2");
        pn.PlaceList.add(p2);

        DataFloat p3 = new DataFloat();
        p3.SetName("p3");
        pn.PlaceList.add(p3);

        DataFloat p10 = new DataFloat();
        p3.SetName("p10");
        pn.PlaceList.add(p10);

        DataFloat p9 = new DataFloat();
        p3.SetName("p9");
        pn.PlaceList.add(p9);

        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "t0";
        t0.InputPlaceName.add("p0");
        t0.InputPlaceName.add("p7");

        Condition T0Ct1 = new Condition(t0, "p0", TransitionCondition.NotNull);
        Condition T0Ct2 = new Condition(t0, "p7", TransitionCondition.NotNull);
        T0Ct1.SetNextCondition(LogicConnector.AND, T0Ct2);

        GuardMapping grdT0 = new GuardMapping();
        grdT0.condition = T0Ct1;
        grdT0.Activations.add(new Activation(t0, "SubPetri", TransitionOperation.Move, "p1"));
        grdT0.Activations.add(new Activation(t0, "p7", TransitionOperation.Move, "p1-p4"));
        grdT0.Activations.add(new Activation(t0, "p1", TransitionOperation.ActivateSubPetri, ""));

        t0.GuardMappingList.add(grdT0);
        t0.Delay = 0;
        pn.Transitions.add(t0);

        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("p1");

        Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "p1", TransitionCondition.SubPetriStopped);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "p1-p8", TransitionOperation.Copy, "p2"));

        t1.GuardMappingList.add(grdT1);
        t1.Delay = 0;
        pn.Transitions.add(t1);

        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("p9");

        Condition T2Ct1 = new Condition(t2, "p9", TransitionCondition.NotNull);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "p9", TransitionOperation.Move, "p3"));
        grdT2.Activations.add(new Activation(t2, "p9", TransitionOperation.Move, "p10"));

        t2.GuardMappingList.add(grdT2);
        t2.Delay = 0;
        pn.Transitions.add(t2);

        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "t3";
        t3.InputPlaceName.add("p3");
        t3.InputPlaceName.add("p2");

        Condition T3Ct1 = new Condition(t3, "p3", TransitionCondition.NotNull);
        Condition T3Ct2 = new Condition(t3, "p2", TransitionCondition.NotNull);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(t3, "p3", TransitionOperation.Move, "p0"));

        t3.GuardMappingList.add(grdT3);
        t3.Delay = 0;
        pn.Transitions.add(t3);

        System.out.println("Coloq started \n ------------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
