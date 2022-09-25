# 파이썬 최신 이미지 빌드
FROM python:latest

# root에 app 폴더 생성
RUN mkdir /app

# work dir 고정
WORKDIR /app/

# host pc의 main.py , requirements.txt 를 아래 경로에 복사
COPY ./requirements.txt /app/requirements.txt

# java stuff
RUN apt-get update && \
    apt-get install -y curl openjdk-8-jdk

# install python packages
RUN pip3 install --upgrade pip
RUN pip3 install --no-cache-dir --upgrade -r /app/requirements.txt

#
COPY ./ /app

EXPOSE 80

# container 실행 시 자동으로 실행 할 command
#  uvicorn을 사용하여 main.py의 app을 실행시킵니다.

CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "80"]


## 참고할거 아래

# FROM tiangolo/uvicorn-gunicorn:python3.8

# # 작업디렉토리 설정
# WORKDIR /code

# COPY ./requirements.txt /code/requirements.txt

# ### install dependencies ###

# # java stuff
# RUN apt-get update && \
#     apt-get install -y curl openjdk-11-jdk

# # install python packages
# RUN pip3 install --upgrade pip
# RUN pip3 install --no-cache-dir --upgrade -r /code/requirements.txt

# # mecab
# RUN cd /code && \ 
#     curl -s https://raw.githubusercontent.com/konlpy/konlpy/master/scripts/mecab.sh | bash -s

# # 현재경로에 존재하는 app의 모든 소스파일을 /code/app 경로 이미지에 복사
# COPY ./app /code/app

# EXPOSE 8000
 
# CMD ["uvicorn", "app.main:app", "--host", "0.0.0.0", "--port", "8000"]