import pygame
import sys
from time import sleep
import random
from pygame.constants import BUTTON_LEFT, KEYDOWN

import serial
ard = serial.Serial('COM3', 9600)

padWidth = 480
padHeight = 640
screen = pygame.display.set_mode((padWidth, padHeight))

button = pygame.image.load('C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\button.png')
buttonSize = button.get_rect().size
buttonWidth = buttonSize[0]
buttonHeight = buttonSize[1]
buttonx = padWidth/2 - buttonWidth/2
buttony = padHeight/2 - buttonHeight/2

def display_start_screen():
    global gamePad
    screen.blit(button, (buttonx,buttony))
    font = pygame.font.Font('NanumGothic.ttf', 75)
    text = '게임시작'
    text = font.render(text ,True, (255,0,0))
    gamePad.blit(text, (padWidth/2-buttonWidth/2-60, padHeight/2-180)) 

def check_button(pos): 
    global start
    if pos[0]<=302 and pos[0]>=178:
        if pos[1]<=370 and pos[1]>=270:
            start = True

rockImage =['C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\rock01.png',\
            'C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\rock02.png',\
            'C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\rock06.png',\
            'C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\rock07.png',\
            'C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\rock08.png',\
            'C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\rock15.png',\
            'C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\rock19.png',\
            'C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\rock21.png',\
            'C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\rock27.png',\
            'C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\rock28.png'
            ]
explosionSound=['C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\wav\\explosion01.wav',\
                'C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\wav\\explosion02.wav',\
                'C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\wav\\explosion03.wav',\
                'C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\wav\\explosion04.wav']

def writeScore(count):
    global gamePad
    font = pygame.font.Font('NanumGothic.ttf', 20)
    text = font.render('파괴한 운석 : '+ str (count), True, (255,255,255))
    gamePad.blit(text, (10, 0)) 

def writePassed(count):
    global gamePad
    font = pygame.font.Font('NanumGothic.ttf', 20)
    text = font.render('놓친 운석 : '+ str (count), True, (255,0,0))
    gamePad.blit(text, (360, 0)) 
    
def writeScore(count):
    global gamePad
    font = pygame.font.Font('NanumGothic.ttf', 20)
    text = font.render('파괴한 운석 : '+ str (count), True, (255,255,255))
    gamePad.blit(text, (10, 0)) 

def writeMessage(text):
    global gamePad, gameOverSound
    textfont = pygame.font.Font('NanumGothic.ttf',60)
    if text == 'over':
        textfont = pygame.font.Font('NanumGothic.ttf',23)
        text = '게임오버! 운석은 3개까지 놓칠 수 있습니다'
    text = textfont.render(text, True, (255, 0, 0))
    textpos = text.get_rect()
    textpos.center =  (padWidth/2,padHeight/2)
    gamePad.blit(text, textpos)
    pygame.display.update()
    pygame.mixer.music.stop()
    gameOverSound.play()
    ard.write(b'2')
    sleep(2)
    pygame.mixer.music.play(-1)
    runGame()



def crash():
    global gamePad
    writeMessage('전투기 파괴!')

def gameOver():
    global gamePad
    writeMessage('over')
    

def drawObject(obj, x, y):
    global gamePad
    gamePad.blit (obj, (x,y))

def initGame():
    global gamePad, clock, background, fighter, missile, explosion, missileSound,button, gameOverSound
    pygame.init()
    gamePad = pygame.display.set_mode((padWidth, padHeight))
    pygame.display.set_caption('Shooting Game')
    background = pygame.image.load('C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\background.png')
    fighter = pygame.image.load('C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\fighter.png')
    missile = pygame.image.load('C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\missile.png')
    explosion = pygame.image.load('C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\image\\explosion.png')
    pygame.mixer.music.load('C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\wav\\music.wav')
    pygame.mixer.music.play(-1)
    missileSound = pygame.mixer.Sound('C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\wav\\missile.wav')
    gameOverSound = pygame.mixer.Sound('C:\\Users\\user\\Desktop\\1211_손재민_개인프로젝트\\wav\\gameover.wav')
    clock = pygame.time.Clock()

def runGame():
    global start,gamePad, clock, background,fighter, missile, explosion, button, missileSound
    fighterSize = fighter.get_rect().size 
    fighterWidth = fighterSize[0]
    fighterHeight = fighterSize[1]

    x = padWidth * 0.45
    y = padHeight *0.9
    fighterX = 0

    missileXY = []
    
    rock = pygame.image.load(random.choice(rockImage))
    rockSize = rock.get_rect().size
    rockWidth = rockSize[0] 
    rockHeight = rockSize[1] 
    rockPassed = 0
    destroySound = pygame.mixer.Sound(random.choice(explosionSound))

    rockX = random.randrange(0, padWidth-rockWidth)
    rockY = 0
    rockSpeed = 2

    isShot = True
    shotCount = 0
    rockPass = 0
    
    onGame = False
    while not onGame:
        
        for event in pygame.event.get():
            if event.type in [pygame.QUIT]:
                pygame.quit()
                sys.exit()
            if event.type in [pygame.KEYDOWN]:
                if event.key == pygame.K_LEFT:
                    fighterX += -3
                    
                elif event.key == pygame.K_RIGHT:
                    fighterX += 3
                    
                elif event.key == pygame.K_SPACE:
                    missileSound.play()
                    missileX = x + fighterWidth/2
                    missileY = y - fighterHeight
                    missileXY.append([missileX, missileY]) 
            if event.type in [pygame.KEYUP]:
                if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
                    fighterX = 0
        
        drawObject(background,0,0)

        x += fighterX

        if x < 0:
            x = 0
        elif x > padWidth - fighterWidth:
            x = padWidth - fighterWidth
        
        if y <= rockY + rockHeight: 
        #     if(rockX >= x and rockX <= x + fighterWidth) or \
        #             (rockX + rockWidth >= x and rockX + rockWidth <= x + fighterWidth):
        #         crash()
            if x + fighterX > rockX and x + fighterX < rockX + rockWidth:
                crash()
            
               
        
        drawObject(fighter, x,y)        

        if len(missileXY) != 0:
            for i,bxy in enumerate(missileXY):
                bxy[1] -= 10
                missileXY[i][1] = bxy[1]
                
                if bxy[1] < rockY:   
                    if bxy[0] > rockX and bxy[0] < rockX + rockWidth:
                        missileXY.remove(bxy)
                        isShot = True 
                        shotCount +=1
                        ard.write(b'1')
                     
                        
                if bxy[1] <= 0:
                    try:
                         missileXY.remove(bxy) 
                    except:
                        pass

        if len(missileXY) != 0:
            for bx, by in missileXY:
                drawObject(missile, bx, by)

        writeScore(shotCount)
        rockY += rockSpeed
        
        if rockY > padHeight:
            rock = pygame.image.load(random.choice(rockImage))
            rockSize = rock.get_rect().size
            rockWidth = rockSize[0] 
            rockHeight = rockSize[1]
            rockX = random.randrange(0, padWidth-rockWidth)
            rockY = 0
            rockPassed +=1
        writePassed(rockPassed)

        if rockPassed == 3:
            gameOver()

        if isShot:
            drawObject(explosion, rockX, rockY) 
            destroySound.play()
            rock = pygame.image.load(random.choice(rockImage))
            rockSize = rock.get_rect().size
            rockWidth = rockSize[0] 
            rockHeight = rockSize[1]
            rockX = random.randrange(0, padWidth-rockWidth)
            rockY = 0
            destroySound = pygame.mixer.Sound(random.choice(explosionSound))
            isShot = False 

            rockSpeed +=0.3
            if rockSpeed >= 10:
                rockSpeed = 10
            
        drawObject(rock, rockX, rockY)
       
       
        pygame.display.update()
        clock.tick(60)

    pygame.quit()

WHITE = (255,255,255)   
start = False 
running = True    
initGame()

while running:
    click_pos = None

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        elif event.type == pygame.MOUSEBUTTONUP:
            click_pos = pygame.mouse.get_pos()

        if click_pos:
            check_button(click_pos)

    pygame.display.update()
    screen.fill(WHITE)

    if start:
       runGame()
    else:
        display_start_screen()

    



