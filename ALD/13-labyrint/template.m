function tem=template(height, width)
tem=zeros(height,width);
parts=1:15;
opt=parts;
for m=1:height
    if(m==1)
        for n=1:width
            tem(m,n)=opt(randi(length(opt)));
            opt=intersect(parts,rightOpt(tem(m,n)));
        end
    else
        for n=1:width
            if(n==1)
            opt=intersect(parts,downOpt(tem(m-1,n)));
            else
             opt=intersect(parts,intersect(rightOpt(tem(m,n-1)),downOpt(tem(m-1,n))));
            end
            tem(m,n)=opt(randi(length(opt)));
        end
    end
end
end