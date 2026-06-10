%potřebuje  Symbolic Math Toolbox, Chebfun - current version
function main(action)
if nargin<1
    action="start";
end
switch action
    case "start"
        fig=figure('Name','Analýza funkce','NumberTitle','off',...
        'Position',[200 100 875 633]);
        inputx=0.55;
        buttonx=0.8;
        inputxlength=buttonx-inputx-0.02; %0.8-0.55-0.2
        buttonxlength=0.16;
        data.bg = uibuttongroup('Visible','off',...
            'Units','normalized', ...
            'Position',[inputx+inputxlength 0  inputxlength 0.20]);
        data.bg2 = uibuttongroup('Visible','off',...
            'Units','normalized', ...
            'Position',[inputx+inputxlength 0.20  inputxlength 0.40]);
        data.inputedit=uicontrol('Style','edit', ...
            'Units','normalized', ...
            'Position',[inputx 0.84 inputxlength 0.05],...
            'String','exp(-(x - 4)^2) + sin(x)/x');
        data.minedit=uicontrol('Style','edit', ...
            'Units','normalized', ...
            'Position',[buttonx-0.07-0.05 0.94 0.05 0.05],...
            'String','-10');
        data.maxedit=uicontrol('Style','edit', ...
            'Units','normalized', ...
            'Position',[buttonx-0.07 0.94 0.05 0.05],...
            'String','10');
        data.exitbutton=uicontrol('Style','push', ...
            'Units','normalized', ...
            'Position',[buttonx 0.94 buttonxlength 0.05], ...
            'String','KONEC', ...
            'FontWeight','bold',...
            'ForegroundColor',[1 0 0],...
            'Callback','main(''close'')');
        data.setupbutton=uicontrol('Style','toggle', ...
            'Units','normalized', ...
            'Position',[buttonx 0.84 buttonxlength 0.05], ...
            'String','NASTAVENÍ', ...
            'FontWeight','bold',...
            'ForegroundColor',[0 0 0],...
            'Callback','main(''setup'')');
        data.calcbutton=uicontrol('Style','push', ...
            'Units','normalized', ...
            'Position',[buttonx 0.74 buttonxlength 0.05], ...
            'String','POČÍTEJ', ...
            'FontWeight','bold',...
            'ForegroundColor',[0 0 0],...
            'Callback','main(''logic'')');
        data.manbutton=uicontrol('Style','push', ...
            'Units','normalized', ...
            'Position',[buttonx 0.64 buttonxlength 0.05], ...
            'String','README', ...
            'FontWeight','bold',...
            'ForegroundColor',[0 0 0],...
            'Callback','main(''help'')');
        data.DoAll = uicontrol(data.bg,'Style','radiobutton', ...
            'Units','normalized', ...
            'Position',[0 0.50 1 0.5], ...
            'String','Vypiš vše',...
            'Callback','main(''manual'')');
        data.ManualSetup = uicontrol(data.bg,'Style','radiobutton', ...
            'Units','normalized', ...
            'Position',[0 0 1 0.5], ...
            'String','Vypiš vybrané',...
            'Callback','main(''manual'')');
        data.Fdiffswitch = uicontrol(data.bg2,'Style','checkbox', ...
            'Units','normalized', ...
            'Position',[0 0.75 1 0.25], ...
            'String','První derivace');
        data.Sdiffswitch = uicontrol(data.bg2,'Style','checkbox', ...
            'Units','normalized', ...
            'Position',[0 0.5 1 0.25], ...
            'String','Druhá derivace');
        data.MonotSwitch = uicontrol(data.bg2,'Style','checkbox', ...
            'Units','normalized', ...
            'Position',[0 0.25 1 0.25], ...
            'String','Monotonnost');
        data.KonSwitch = uicontrol(data.bg2,'Style','checkbox', ...
            'Units','normalized', ...
            'Position',[0 0 1 0.25], ...
            'String','Konkávnost a konvexnost');
        uicontrol('Style','text', ...
            'Units','normalized', ...
            'String','D(f)',...
            'Position',[buttonx-0.07-0.10 0.93 0.05 0.05]);
        uicontrol('Style','text', ...
            'Units','normalized', ...
            'String','f(x)',...
            'Position',[inputx-0.04 0.83 0.04 0.05]);
        data.Fdiff = uicontrol('Style','text', ...
            'Units','normalized', ...
            'Position',[0.05 0.40 0.7 0.05]);
        data.Sdiff = uicontrol('Style','text', ...
            'Units','normalized', ...
            'Position',[0.05 0.30 0.7 0.05]);
        data.monot = uicontrol('Style','text', ...
            'Units','normalized', ...
            'Position',[0.05 0.20 0.7 0.05]);
        data.kon = uicontrol('Style','text', ...
            'Units','normalized', ...
            'Position',[0.05 0.10 0.7 0.05]);
        data.graf=axes('Position',[0.05 0.56 0.45 0.43]);
        set(fig,'UserData',data);
    case "manual"
        data=get(gcf,'UserData');
        if data.DoAll.Value==0
            data.bg2.Visible="on";
        else
            data.bg2.Visible="off";
        end
        set(gcf,'UserData',data);
    case "setup"
        data=get(gcf,'UserData');
        main('manual');
        if data.setupbutton.Value==0
            data.bg.Visible="off";
            data.bg2.Visible="off";
            data.calcbutton.Enable="on";
            data.restartbutton.Enable="on";
        else
            data.bg.Visible="on";
            data.calcbutton.Enable="off";
            data.restartbutton.Enable="off";
        end
        set(gcf,'UserData',data);
    case "logic"
        %setup
        clc
        data=get(gcf,'UserData');
        syms x
        cla;
        data.Fdiff.String="";
        data.Sdiff.String="";
        data.monot.String="";
        data.kon.String="";
        rostouci="";
        klesajici="";
        konvexni="";
        konkavni="";
        eps=0.0000001;
        tol=0.01;
        vAsimpt=[];
        zeroF=[];
        zeroDP=[];
        zeroDD=[];
        %input
        Err=false;
        YaBe=false;
        upperB=str2double(data.maxedit.String);
        lowerB=str2double(data.minedit.String);
        
        try 
            f=str2sym(data.inputedit.String);
            if data.inputedit.String==""||(~isnan(subs(f,NaN))&&subs(f,NaN)~=f)||YaBe==true
                data.monot.String='Chybně zadaná funkce';
                Err=true;
            end
        catch
            data.monot.String='Chybně zadaná funkce';
            Err=true;
        end
        
        if ~isfinite(upperB)
            data.Fdiff.String='Chybně zadaná horní hranice intervalu';
            Err=true;
        end
        if ~isfinite(lowerB)
            data.Sdiff.String='Chybně zadaná dolní hranice intervalu';
            Err=true;
        end
        if lowerB==upperB
            data.kon.String='Shodné hranice intervalu';
            Err=true;
        end
        if Err==false
            if upperB<lowerB
                tmp=upperB;
                upperB=lowerB;
                lowerB=tmp;
            end
            f=subs(f,x);
            %derivace - Vypocty
            pDerivace = simplify(diff(f));
            dDerivace = simplify(diff(f,2));
            %bez tohoto bývaly problémy
            [numF, denom]=numden(f);
            [numDP, ~]=numden(pDerivace);
            [numDD, ~]=numden(dDerivace);
            
            splitting('on');
            if isnan(subs(denom,x,NaN))
                vAsimpt=uniquetol(roots(chebfun(matlabFunction(denom),[lowerB,upperB])),tol);
                vAsimpt(imag(vAsimpt)~=0)=NaN;
                vAsympt=[];
                for count = 1:length(vAsimpt)
                    tmp=limit(f,x,vAsimpt(count));
                    if tmp+eps > eps^(-1) || tmp-eps < -eps^(-1) || isnan(tmp)
                        vAsympt(end+1)=vAsimpt(count);
                    end
                end
            end
            allB=unique([lowerB;vAsimpt;upperB]);
            %hledání f(x) && pDerivace(x) && dDerivace(x) == 0
            for count = 1:(length(allB)-1)
                if isnan(subs(numF,x,NaN))
                    zeroF=[zeroF;roots(chebfun(matlabFunction(f),[allB(count),allB(count+1)]))];
                end
                if isnan(subs(numDP,x,NaN))
                    zeroDP=[zeroDP;roots(chebfun(matlabFunction(numDP),[allB(count),allB(count+1)]))];
                end
                if isnan(subs(numDD,x,NaN))
                    zeroDD=[zeroDD;roots(chebfun(matlabFunction(numDD),[allB(count),allB(count+1)]))];
                end
            end
            tmp=sort(uniquetol([zeroDD;allB],tol));
            for count = 1:(length(tmp)-1)
                if isnan(subs(numDD,x,NaN))
                    zeroDD=[zeroDD;roots(chebfun(matlabFunction(dDerivace),[MyRound(tmp(count),0,2),MyRound(tmp(count+1),1,2)]))];
                end
            end
            %generování rostoucí/klesající intervaly
            pDerivaceB=sort(uniquetol([zeroDP;allB],tol));
                for count = 1:(length(pDerivaceB)-1)
                    tmp=(pDerivaceB(count)+pDerivaceB(count+1))/2;
                    try
                        if subs(pDerivace,x,tmp)>0
                            if rostouci == ""
                                rostouci=append(rostouci,"(",string(round(pDerivaceB(count),4)),";",string(round(pDerivaceB(count+1),4)),")");
                            else
                                rostouci=append(rostouci,"U(",string(round(pDerivaceB(count),4)),";",string(round(pDerivaceB(count+1),4)),")");
                            end
                        elseif subs(pDerivace,x,tmp)<0
                            if klesajici == ""
                                klesajici=append(klesajici,"(",string(round(pDerivaceB(count),4)),";",string(round(pDerivaceB(count+1),4)),")");
                            else
                                klesajici=append(klesajici,"U(",string(round(pDerivaceB(count),4)),";",string(round(pDerivaceB(count+1),4)),")");
                            end
                        end
                    catch
                    end
                end
            %generování konkávní/konvexní intervaly
            dDerivaceB=sort(uniquetol([zeroDD;allB],tol));
                for count = 1:(length(dDerivaceB)-1)
                    tmp=(dDerivaceB(count)+dDerivaceB(count+1))/2;
                    try
                        if subs(dDerivace,x,tmp)>0
                            if konvexni == ""
                                konvexni=append(konvexni,"(",string(round(dDerivaceB(count),4)),";",string(round(dDerivaceB(count+1),4)),")");
                            else
                                konvexni=append(konvexni,"U(",string(round(dDerivaceB(count),4)),";",string(round(dDerivaceB(count+1),4)),")");
                            end
                        elseif subs(dDerivace,x,tmp)<0
                            if konkavni == ""
                                konkavni=append(konkavni,"(",string(round(dDerivaceB(count),4)),";",string(round(dDerivaceB(count+1),4)),")");
                            else
                                konkavni=append(konkavni,"U(",string(round(dDerivaceB(count),4)),";",string(round(dDerivaceB(count+1),4)),")");
                            end
                        end
                    catch
                    end
                end
            %vodorovné asymptoty
            hAsympt1=limit(f,x,Inf);
            hAsympt2=limit(f,x,-Inf);
            %derivacce vypis
            f=str2sym(data.inputedit.String);
            pDerivace = simplify(diff(f));
            dDerivace = simplify(diff(f,2));
            %výpis
            data.graf=fplot(f,'LineWidth',1);
            hold on;
            data.graf=fplot(f,[lowerB,upperB],'lineWidth',1);
            %data.graf=fplot(dDerivace)
            if isfinite(hAsympt1)
                data.graf=fplot(hAsympt1,'--k');
            end
            if isfinite(hAsympt2) && hAsympt1 ~= hAsympt2
                data.graf=fplot(hAsympt2,'--k');
            end
            xlabel('x');
            ylabel('y');
            legend("f(x)","f(x) na intervalu");
            legend("show");
            hold off;
            if data.DoAll.Value==1 || data.Fdiffswitch.Value==1
                data.Fdiff.String='První derivace: '+string(pDerivace);
            end
            if data.DoAll.Value==1 || data.Sdiffswitch.Value==1
                data.Sdiff.String='Druhá derivace: '+string(dDerivace);
            end
            if data.DoAll.Value==1 || data.MonotSwitch.Value==1
                data.monot.String='Rostoucí interval: '+string(rostouci)+newline+'Klesající interval: '+string(klesajici);
            end
            if data.DoAll.Value==1 || data.KonSwitch.Value==1
                data.kon.String='Konvexní interval: '+string(konvexni)+newline+'Konkávní interval: '+string(konkavni);
            end
        end
        set(gcf,'UserData',data);
    case "help"
        if numel(findall(groot,'Type','figure','Name','Manuál'))~=1
            figure('Name','Manuál','NumberTitle','off');
            uicontrol('Style','text', ...
                'Units','normalized', ...
                'Position',[0 0 1 1], ...
                'String','"f(x)" Funkce, kterou chceme analyzovat');
            uicontrol('Style','text', ...
                'Units','normalized', ...
                'Position',[0 0 1 0.9], ...
                'String','"D(f)" Definiční obor, na kterém má být funkce analyzována.');
            uicontrol('Style','text', ...
                'Units','normalized', ...
                'Position',[0 0 1 0.8], ...
                'String','Tlačítko KONEC ukončí všechny okna vyvolané matlabem');
            uicontrol('Style','text', ...
                'Units','normalized', ...
                'Position',[0 0 1 0.7], ...
                'String','Pomocí tlačítka NASTAVENÍ lze nastavit, které vlastnosti se (ne)budou vypisovat');
            uicontrol('Style','text', ...
                'Units','normalized', ...
                'Position',[0 0 1 0.6], ...
                'String','Tlačítko POČÍTEJ zpracovává vstupy a vypisuje chtěné hodnoty');
            uicontrol('Style','text', ...
                'Units','normalized', ...
                'Position',[0 0 1 0.5], ...
                'String','Tlačítko README vám zobrazí toto okno');
            uicontrol('Style','text', ...
                'Units','normalized', ...
                'Position',[0 0 1 0.4], ...
                'String','PRO SPRÁVNOU FUNKCI JE NUTNÉ');
            uicontrol('Style','text', ...
                'Units','normalized', ...
                'Position',[0 0 1 0.3], ...
                'String','Mít v matlabu přidány addony: Symbolic Math Toolbox, Chebfun - current version. Chebfun je komunitní addon.');
            uicontrol('Style','text', ...
                'Units','normalized', ...
                'Position',[0 0 1 0.2], ...
                'String','D(f) nastavit jako různá reálná čísla s maximálně dvěma desetinými čísly. Zajistit, že je f(x) na zadaném intervalu spojitá. Do f(x) psát předpis funkce v symbolickém matlabovském tvaru. př.: ln(x) zapsat jako log(x), arctang(x) zapsat jako atan(x).');
        else
            figure(findall(groot,'Type','figure','Name','Manuál'));
        end
    case "close"
        close gcf;
        if numel(findall(groot,'Type','figure','Name','Manuál'))==1
            figure(findall(groot,'Type','figure','Name','Manuál'));
            close gcf;
        end
end
end