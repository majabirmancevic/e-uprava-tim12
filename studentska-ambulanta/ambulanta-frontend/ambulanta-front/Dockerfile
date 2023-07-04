# Stage 1
FROM node:18.16.0-alpine 
WORKDIR /app
# RUN npm install -g @angular/cli

COPY package.json .
COPY package-lock.json .

RUN npm install

COPY . .
EXPOSE 4201

CMD [ "npm", "start" ]

