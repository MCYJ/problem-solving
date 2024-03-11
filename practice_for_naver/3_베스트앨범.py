# 24.03.13 00:30 ~

def solution(genres, plays):
    answer = []

    dict_genre = {}
    dict_song = {}

    for idx, (genre, play) in enumerate(zip(genres, plays)):
        if genre in dict_genre:
            dict_genre[genre] += play
            dict_song[genre].append([idx, play])
        else:
            dict_genre[genre] = play
            dict_song[genre] = [[idx, play]]

    for genre, play in sorted(dict_genre.items(), key=lambda item: item[1], reverse=True):
        for idx, (song_code, play) in enumerate(sorted(dict_song[genre], key=lambda x: x[1], reverse=True)):
            if idx >= 2:
                break
            answer.append(song_code)

    return answer

genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]


