# Preliminary merge builds of pull request branches

## Исходная задача:
https://internship.jetbrains.com/projects/953/?tab=project

TeamCity реализует интеграцию с целым рядом VCS hosting сервисов, таких как GitHub, GitLab, Bitbucket Cloud & Server и т.д. В числе прочего, реализована возможность использовать информацию о пулл-реквестах предоставляемую этими сервисами, чтобы запускать сборки на соответствующих ревизиях исходного кода перед тем, как пулл реквест будет одобрен и включен в основную ветку соответствующего репозитория. За то время, пока пулл реквест остаётся открытым, эта основная ветка может тоже продвинуться вперёд. Многим нашим пользователям было бы полезно иметь возможность учитывать её текущее состояние в таких билдах, включая их (локально) в исходную ветку пулл реквеста.

## Решение:
Написать yml config файл для GithubActions - который 
предворительно смёрджит текушую ветку в целевую ветку пулл реквеста(в данном случае master branch) и 
сообщит о результате тестирование предворительного мёрджа.

## Реализация:

### info
Данный пример написан на Java8 с использованием maven.

### Шаги
* создадим из `master` - три ветки :
```shell
bubble-sort
insertion-sort
selection-sort
```

* Реализуем соответствующие алгоритмы сортировки
```shell
в ветке: bubble-sort - сортировку пузырьком
в ветке: insertion-sort - сортировку вставками
в ветке: selection-sort - сортировку выбором
```

* Зальём ветки `bubble-sort` и `insertion-sort` ветки в `master`. 
Останется ветка `selection-sort`.

* Создадим пулл реквест из ветки `selection-sort` в `master`.

* Проверим в GithubActions, что на самом деле в смёрдженном вариаанет 
- запустились тесты для трёх реализованных алгоритмов.

## Немного про решение:

#### Конечный код скрипта можно посмотреть тут :
https://github.com/RooBarsic/git-test/blob/master/.github/workflows/testing-config.yml

### Склонируем master ветку и текушую вертку пулл реквеста в одну и туже директорию
```shell
  # Clone master and current branches
  - name: Clone master branch
    run: git clone --branch master https://github.com/owner_name/repository_name/.git

  - name: Clone current branch to previously clonned master branch
    working-directory: ./repository_name
    run: git fetch origin cur_branch_name:cur_branch_name
```
В нашем примере будет так
```shell
  # Clone master and current branches
  - name: Clone master branch
    run: git clone --branch master https://github.com/RooBarsic/git-test/.git

  - name: Clone current branch to previously clonned master branch
    working-directory: ./git-test
    run: git fetch origin selection-sort:selection-sort
```
### Локально смёрджим обе ветки в одну
* PS: для этого может понадобится настроить в гите `user.name` и `user.email`
```shell
  git config --global user.name $GIT_DEFAULT_USER_NAME
  git config --global user.email $GIT_DEFAULT_USER_EMAIL  
```
Для мёрджа используем команду `git merge branch name`
```shell
  # Locally merge two branches
  - name: merge master with current branch
    working-directory: ./repository_name
    run: |
      git checkout master
      git merge cur_branch_name
```
В нашем примере будет как
```shell
  # Locally merge two branches
  - name: merge master with current branch
    working-directory: ./git-test
    run: |
      git checkout master
      git merge selection-sort
```

### Протестируем мёрдж
```shell
  # Testing the result of merging
  - name: Run tests for merge result
    working-directory: ./repository_name
    run: mvn test
```
В нашем примере будет как
```yml
  # Testing the result of merging
  - name: Run tests for merge result
    working-directory: ./git-test
    run: mvn test
```

# Что можно было сделать лучше?
1. Избавиться от зависимости что target branch (куда делается пулл реквест) - это по умолчанию master в нашем случае
2. 
