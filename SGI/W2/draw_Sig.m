function draw_Sig(t,y,typ)
y(end+1,:)=sum(y);
poc=size(y,1);
for i=1:poc
    subplot(1,poc,i);
    stem(t,y(i,:));
    
    ylabel("Cos(t)");
    xlabel("t[s]");
    if i~=poc
    title("signal "+i);
    else
    title("suma signalu");
    end
end
end

