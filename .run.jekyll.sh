#/usr/bin/env bash
set -e

echo "⚙️  Building with Jekyll"
gem install bundler
bundle install
bundle exec jekyll build

echo "⚙️  Copying the files"
rm -rf _gh_pages/*
cp -R _site/* _gh_pages/

echo "🚀 Commit and push"
cd _gh_pages || exit
git add -A
git commit --author="Vert.x howtos <howtos@vertx.io>" -m "Deploy the how-to pages"
git push origin gh-pages

echo "✅ Done"
