clear;clc;
data=convertCharsToStrings(readtable("insurance.csv"));
smokers=data(data.smoker=="yes",:);
nonsmokers=data(data.smoker=="no",:);

[k_age_smokers,q_age_smokers]=lin_regression(smokers.age,smokers.charges);
[k_age_nonsmokers,q_age_nonsmokers]=lin_regression(transpose(nonsmokers.age),nonsmokers.charges);
[k_bmi_smokers,q_bmi_smokers]=lin_regression(smokers.bmi,smokers.charges);
[k_bmi_nonsmokers,q_bmi_nonsmokers]=lin_regression(nonsmokers.bmi,nonsmokers.charges);
[k_chil_smokers,q_chil_smokers]=lin_regression(smokers.children,smokers.charges);
[k_chil_nonsmokers,q_chil_nonsmokers]=lin_regression(nonsmokers.children,nonsmokers.charges);



f0=figure(1);
clf;

scatter(smokers.age,smokers.charges,"red");
hold on;
fplot(@(x) k_age_smokers*x+q_age_smokers,"Color","red");
scatter(nonsmokers.age,nonsmokers.charges,"blue");
fplot(@(x) k_age_nonsmokers*x+q_age_nonsmokers,"Color","blue");

if q_age_smokers<0
    f="f(x)= "+round(k_age_smokers,2)+"x - "+abs(round(q_age_smokers,2));
else
    f="f(x)= "+round(k_age_smokers,2)+"x + "+round(q_age_smokers,2);
end
if q_age_nonsmokers<0
    g="g(x)= "+round(k_age_nonsmokers,2)+"x - "+abs(round(q_age_nonsmokers,2));
else
    g="g(x)= "+round(k_age_nonsmokers,2)+"x + "+round(q_age_nonsmokers,2);
end

legend("smokers",f,"nonsmokers",g);
xlabel("age");
ylabel("chargres");



f1=figure(2);
clf;

scatter(smokers.bmi,smokers.charges,"red");
hold on;
fplot(@(x) k_bmi_smokers*x+q_bmi_smokers,"Color","red");
scatter(nonsmokers.bmi,nonsmokers.charges,"blue");
fplot(@(x) k_bmi_nonsmokers*x+q_bmi_nonsmokers,"Color","blue");

if q_bmi_smokers<0
    f="f(x)= "+round(k_bmi_smokers,2)+"x - "+abs(round(q_bmi_smokers,2));
else
    f="f(x)= "+round(k_bmi_smokers,2)+"x + "+round(q_bmi_smokers,2);
end
if q_bmi_nonsmokers<0
    g="g(x)= "+round(k_bmi_nonsmokers,2)+"x - "+abs(round(q_bmi_nonsmokers,2));
else
    g="g(x)= "+round(k_bmi_nonsmokers,2)+"x + "+round(q_bmi_nonsmokers,2);
end

legend("smokers",f,"nonsmokers",g);
xlabel("bmi");
ylabel("chargres");



saveas(f0,"graph_age.png");
saveas(f1,"graph_bmi.png");
% 
% f1=figure(2);
% clf;
% 
% scatter(smokers.children,smokers.charges,"red");
% hold on;
% fplot(@(x) k_chil_smokers*x+q_chil_smokers,"Color","red");
% scatter(nonsmokers.children,nonsmokers.charges,"blue");
% fplot(@(x) k_chil_nonsmokers*x+q_chil_nonsmokers,"Color","blue");
% 
% if q_chil_smokers<0
%     f="f(x)= "+round(k_chil_smokers,2)+"x - "+abs(round(q_chil_smokers,2));
% else
%     f="f(x)= "+round(k_chil_smokers,2)+"x + "+round(q_chil_smokers,2);
% end
% if q_chil_nonsmokers<0
%     g="g(x)= "+round(k_chil_nonsmokers,2)+"x - "+abs(round(q_chil_nonsmokers,2));
% else
%     g="g(x)= "+round(k_chil_nonsmokers,2)+"x + "+round(q_chil_nonsmokers,2);
% end
% 
% legend("smokers",f,"nonsmokers",g);
% xlabel("chil");
% ylabel("chargres");
figure(3)
clf;
scatter3(data.age,data.children,data.charges)
figure(4)
clf;
scatter3(data.bmi,data.children,data.charges)