#构建镜像
docker build -t rem-db:1.0 .    #注意此处有个".",意思是文件存放于当前文件夹.可随意设置文件位置

#运行
#!/bin/sh
echo "Rem-db start"
docker run -d -it -p 7891:7891 -v /home/workspace/remdb:/home/remdb --name Rem-db --restart=always rem-db:1.0
docker logs -f Rem-db
echo "Rem-db success"